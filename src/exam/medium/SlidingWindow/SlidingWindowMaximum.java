package exam.medium.SlidingWindow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    /**
     * 239.Sliding Window Maximum
     * 寻找每个滑动窗口中的最大值
     *
     * 重点：使用优先队列，保持一个有k个元素的优先队列， 单调栈也可以
     * 优先队列中存在元素和元素位置，队列中保持递减，
     * 第一个元素最大，每次新加元素的时候
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[]{};

        if(nums==null || nums.length<=0 || k<=0){
            return result;
        }
        if(k==1){
            return nums;
        }
         result=new int[nums.length-k+1];

        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for(int i=0;i<nums.length;i++){
            if(queue.size()<k){
                int[] temp=new int[]{nums[i],i};
                queue.add(temp);
            }
            if(i==k-1){
                result[i-k+1]=queue.peek()[0];
            }else if(queue.size()>=k){
                //两种情况，第一个元素是最大的，第一个元素不是最大的
                if(queue.peek()[1]<=i-k) {//说明第一个元素是最大的
                    while(queue.peek()[1]<=i-k){ //对于在第一位之前的元素都要删除掉
                        queue.remove();
                    }
                    int[] temp=new int[]{nums[i],i};
                    queue.add(temp);
                    result[i-k+1]=queue.peek()[0];
                }else {
                    int[] temp=new int[]{nums[i],i};
                    queue.add(temp);
                    result[i-k+1]=queue.peek()[0];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a=new int[]{9,10,9,-7,-4,-8,2,-6};
        maxSlidingWindow(a,5);
    }
}
