package exam.medium.DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     * 295. Find Median from Data Stream
     * 设计一个数据类，实现往数组中添加元素，返回数组的中值
     *
     * 重点，使用两个堆保存元素，
     * 一个堆存在前一半的元素，按照从大到小存放，堆顶元素为最大值
     * 一个堆存放后一半的元素，按照从小到大存放，堆顶元素为最小值
     *      取中值的时候，如果是奇数，取前一个堆的最大元素，如果是偶数，取两个堆的堆顶元素的平均数
     */
    /** initialize your data structure here. */
    PriorityQueue<Integer> maxheap; //后半段 从小到大
    PriorityQueue<Integer> minheap; //前半段 从大到小

    public FindMedianFromDataStream() {
        maxheap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        minheap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public void addNum(int num) {//要维持两个堆的元素个数
        // 如果前半段为空，或者元素比前半段最大元素小
        if(minheap.size() == 0 || num <= minheap.peek()){
            // 如果前半段元素过多，需要给后半部分
            if(minheap.size() > maxheap.size()){
                maxheap.offer(minheap.poll());
            }
            minheap.offer(num);
            // 数字大于后半段元素的最小值   或者后半段元素为空
        } else if (maxheap.size() == 0 || num > maxheap.peek()){
            //如果前半段元素个数大于后半段元素
            if(maxheap.size() > minheap.size()){
                minheap.offer(maxheap.poll());
            }
            maxheap.offer(num);
            // 数字在两个堆顶之间的情况
        } else {
            if(minheap.size() <= maxheap.size()){
                minheap.offer(num);
            } else {
                maxheap.offer(num);
            }
        }

    }

    public double findMedian() {
        // 返回大小较大的那个堆堆顶，如果大小一样说明是偶数个，则返回堆顶均值
        if(minheap.size() > maxheap.size()){
            return minheap.peek();
        } else if (minheap.size() < maxheap.size()){
            return maxheap.peek();
        } else if (minheap.isEmpty() && maxheap.isEmpty()){
            return 0;
        } else {
            return (minheap.peek() + maxheap.peek()) / 2.0;
        }
    }
}
