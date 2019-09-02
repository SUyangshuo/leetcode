package exam.medium.Array;

public class FirstMissingPositive {
    /**
     * 41. First Missing Positive
     * 在一个未排序的数组中找到i-n中第一个缺失的值，最好时间复杂度为o（n）
     *
     * 重点：方法一：首先对数组进行排序，找到第一个正数，
     *      如果正数不为1则说明第一个缺失值为1，如果正数为1，
     *      记录1和下标的差值，向后依次遍历，这样会导致时间复杂度为n*logn
     *      方法一比较全面，还可以应对有负数的情况，时间复杂度稍高
     *      方法二：不预排序，利用数组下标保存信息
     */

    //方法二：不用预排序，速度最快
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;

        for(int i=0;i<A.length;i++){//原地交换  时间复杂度为on
            if(A[i]<=A.length && A[i]>0 && A[A[i]-1]!=A[i]){
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
                i--;
            }
        }

        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1)
                return i+1;
        }

        return A.length+1;
    }
}
