package exam.medium.DataStructure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Solution {
    /**
     * 384. Shuffle an Array
     * 设定一个数据结构，打散一个数组
     *重点 :
     *      方法一：先对一个数组进行全排列，然后随机挑选一个返回
     *      方法二：手动随机，遍历数组，每次以1/i的几率替换i之前的元素，这样重复n次（数组长度）
     *      设x元素在第m次的时候出现在位置i的概率是1/m,那么在第m+1次的时候，x仍然待在位置i的概率是 1/m * m/(m+1) = 1/(m+1)）
     */

    //方法一：
    int[] a;
    List<List<Integer>> list=new ArrayList<>();
    public Solution(int[] nums) {
        this.a=nums;
        //给出全部的排列
        permutation(this.list,a,0);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return a;
    }

    /** Returns a random shuffling of the array. */
    public  int[] shuffle() {
        Collections.shuffle(list);
        int[] result=new int[list.get(0).size()];
        for(int i=0;i<list.get(0).size();i++) result[i] = list.get(0).get(i);
        return result;
    }
    public   void permutation(List<List<Integer>> list,int[] a,int index){
        if(index==a.length-1){
            List<Integer> temp = new ArrayList<>();
            for (Integer item : a)
                temp.add(item);
            list.add(temp);
        }else for(int i=index;i<a.length;i++){
            swap(a,i,index);
            permutation(list,a,index+1);
            swap(a,i,index);
        }

    }
    public  void swap(int[] t,int a,int b){
        int temp=t[a];
        t[a]=t[b];
        t[b]=temp;
    }
}
public class ShuffleAnArray{
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3};
        Solution solution=new Solution(a);
        System.out.println(solution.shuffle());
    }
}

/**ac
 */
class Solution3 {
    private int[] origNums;
    private int[] randNums;
    private Random random;

    public Solution3(int[] nums) {
        origNums = nums.clone();
        randNums = nums.clone();
        random   = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int range = randNums.length; range > 1; range--) {
            int index = random.nextInt(range);
            // if index == range - 1, no swapping needed
            if (index == range - 1) continue;
            // swap the numbers
            randNums[index]     ^= randNums[range - 1];
            randNums[range - 1] ^= randNums[index];
            randNums[index]     ^= randNums[range - 1];
        }
        return randNums;
    }
}



//看起来正常，不明白为什么无法ac
class Solution2 {
    private int[] nums;
    private Random random;

    public Solution2(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
