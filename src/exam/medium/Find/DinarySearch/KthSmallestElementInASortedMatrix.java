package exam.medium.Find.DinarySearch;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    /**
     * 378. Kth Smallest Element in a Sorted Matrix
     * 根据给定的数组，求出数组中第k小的元素，数组从左到右，从上到下依次递增
     *
     * 方法一：使用优先队列，利用一个小顶堆，先把第一行的元素放进去，弹出最小的元素，
     *      然后把弹出严肃的下一行元素添加到队列中，如果遇到最后一行，就把弹出元素的右边元素添加进队列
     *      这样可以保证左边比较小的元素最先进，弹出的第k次就是结果
     *  方法二：二分法
     */
    public static void main(String[] args) {
        int[][] a=new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest2(a,8));

    }

    //方法一
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0 ||k<=0){
            return -1;
        }
        if(k==1){
            return matrix[0][0];
        }
        PriorityQueue<Tuple> queue=new PriorityQueue<>();
        for(int i=0;i<matrix[0].length;i++){
            Tuple temp=new Tuple(0,i,matrix[0][i]);
            queue.offer(temp);
        }
        int m=matrix.length,n=matrix[0].length;
        while(k>1){
            Tuple tuple=queue.poll();
            Tuple nextTuple;
            if(tuple.x!=m-1){//说明不是最后一行
                 nextTuple=new Tuple(tuple.x+1,tuple.y,matrix[tuple.x+1][tuple.y]);
                 queue.offer(nextTuple);
            }
            k--;
        }
        return queue.poll().val;

    }
    class Tuple implements Comparable<Tuple>{//创建优先队列中的比较元素
        int x, y, val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple a){
            return this.val - a.val;
        }
    }

    //方法二：二分法，每次取最大值和最小值的中间值，
    //        判断整个数组中小于中间值的有多少，如果大于count
    //          最大值收缩为中间值，反之，最小值收缩为中间值，
    //          当最大值和最小值收缩为相等的时候就是求的值
    public static int kthSmallest2(int[][] matrix, int k) {
        if(matrix==null || matrix.length<=0 || matrix[0].length<=0 ||k<=0){
            return -1;
        }
        if(k==1){
            return matrix[0][0];
        }
        int lo=matrix[0][0];   //最小值
        int ho=matrix[matrix.length-1][matrix[0].length-1];  //最大值

        while(lo<ho){
            int count=0;
            int mid = lo+(ho-lo)/2;
            //开始二分遍历数组 寻找小于mid数量
            int j=matrix[0].length-1;//每次从右上角元素开始二分遍历，右上角元素某种程度上是中间值
            for(int i=0;i<matrix.length;i++){
                while(j>=0 && matrix[i][j] > mid){
                       j--;
                }
                count=count+j+1;
            }
            if(count<k){//最大值收缩为mid
                lo=mid+1;
            }else{
                ho=mid;
            }
        }
        return lo;
    }

}

