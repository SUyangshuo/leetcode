package exam.medium.Array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    /**
     * 581. Shortest Unsorted Continuous Subarray
     * 最长的无序串
     */
    //方法一：从头部和尾部遍历按照顺序遍历，遇到不符合标准的标记下
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length,beg =-1,end=-2,mn=nums[n-1],mx=nums[0];
        for(int i=1;i<n;i++){
            mx=Math.max(mx,nums[i]);
            mn = Math.min(mn, nums[n-1-i]);
            if (nums[i]<mx) end=i;
            if(nums[n-1-i]>mn) beg=n-1-i;
        }
        return end-beg+1;
    }
    //方法二 ：对数组排序后和原数组按照位置比较
    public int findUnsortedSubarray2(int[] nums) {
//        拷贝数组，并将数组复制
        int[] copy = new int[nums.length];
        copy = (int[]) nums.clone();

//        数组排序
        Arrays.sort(copy);

//        从两头分别找出与排序好的元素值不同的元素下标
        int start=0, end=nums.length-1;
        for (; start < nums.length; start++) {
            if (nums[start]!=copy[start])   break;
        }
        for (; end >start; end--) {
            if (nums[end]!=copy[end])   break;
        }
        return end-start+1;
    }
}
