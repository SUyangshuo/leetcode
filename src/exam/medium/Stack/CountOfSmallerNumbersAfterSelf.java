package exam.medium.Stack;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    /**
     *     315. Count of Smaller Numbers After Self
     *     根据给定的数组，判断每个位置之后有多少元素大于本身
     *
     *     使用单调栈 从后往前遍历，保持栈内从下到上递增---超时--原因在于进栈出栈耗时
     *     将进栈出栈改为二分插入，依然超时
     *     真正解法是使用归并排序，其后面的逆序数等于在排序过程中需要移动到该数前面的个数。时间复杂度O(nlogn)。
     */
    //第一步使用单调栈，之能ac90%，最后一个超时
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new LinkedList<>();

        if(nums==null || nums.length==0){
            return result;
        }
        Integer[] tempResult=new Integer[nums.length];
        Stack<Integer> stack=new Stack<>();
        List<Integer> list=new LinkedList<>();
        for(int i = nums.length-1;i>=0;i--){
            while (!stack.empty() && stack.peek()>=nums[i]) {
                list.add(0,stack.pop());
            }
            tempResult[i]=stack.size();
            stack.add(nums[i]);
            if(!list.isEmpty()){
                stack.addAll(list);
                list.clear();
            }
        }
        return Arrays.asList(tempResult);
    }
    //第二步将栈优化为二分法查找，但是还是超时，猜测是linklist中添加元素太耗时
    public static List<Integer> countSmaller2(int[] nums) {
        List<Integer> result=new LinkedList<>();

        if(nums==null || nums.length==0){
            return result;
        }
        Integer[] tempResult=new Integer[nums.length];
        List<Integer> list=new LinkedList<>();
        for(int i = nums.length-1;i>=0;i--){
            //对栈的判断更换为二分查找

            int l=0,r=list.size();
            while(l<r){
                int temp=l+(r-l)/2;

                if(list.get(temp)>=nums[i]){
                    r=temp;
                }else {
                    l=temp+1;
                }
            }
            tempResult[i]=r;
            list.add(r,nums[i]);

        }
        return Arrays.asList(tempResult);
    }
    //二分法的标准答案
    public List<Integer> countSmaller3(int[] nums) {
        int[] smaller = new int[nums.length];
        for(int i=nums.length-2; i>=0; i--) {
            int left = i+1;
            int right = nums.length-1;
            while (left<=right) {
                int m = (left+right)/2;
                if (nums[i] > nums[m]) right = m - 1;
                else left = m + 1;
            }
            smaller[i] = nums.length - left;
            int temp = nums[i];
            for(int j=i; j<right; j++) nums[j] = nums[j+1];
            nums[right] = temp;
        }
        List<Integer> results = new ArrayList<>(nums.length);
        for(int i=0; i<smaller.length; i++) results.add(smaller[i]);
        return results;
    }
    //使用功归并排序 应用合并排序。如果我们对数组进行排序，那么对于某个特定的数据，
    // 其后面的逆序数等于在排序过程中需要移动到该数前面的个数。时间复杂度O(nlogn)。
    private void sort(int[] nums, int[] smaller, int[] pos, int from, int to) {
        if (from >= to) return;
        int m = (from + to) / 2;
        sort(nums, smaller, pos, from, m);
        sort(nums, smaller, pos, m+1, to);
        int[] merged = new int[to-from+1];
        int i=from, j=m+1, k=0, jump = 0;
        while (i<=m || j<=to) {
            if (i>m) {
                jump ++;
                merged[k++] = pos[j++];
            } else if (j>to) {
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else {
                jump ++;
                merged[k++] = pos[j++];
            }
        }
        for(int p=0; p<merged.length; p++) pos[from+p] = merged[p];
    }
    public List<Integer> countSmaller4(int[] nums) {
        int[] smaller = new int[nums.length];
        int[] pos =new int[nums.length];
        for(int i=0; i<pos.length; i++) pos[i] = i;
        sort(nums, smaller, pos, 0, nums.length-1);
        List<Integer> result = new ArrayList<>(nums.length);
        for(int i=0; i<nums.length; i++) result.add(smaller[i]);
        return result;
    }




    public static void main(String[] args) {
        countSmaller2(new int[]{5,2,6,1});
    }
}
