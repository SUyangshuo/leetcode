package exam.medium.SlidingWindow;

import java.util.Comparator;
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
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for(int i=0;i<nums.length;i++){
            if(queue.size()!=k){
                
            }
        }
    }
}
