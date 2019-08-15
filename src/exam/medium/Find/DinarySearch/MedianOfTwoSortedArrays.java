package exam.medium.Find.DinarySearch;

public class MedianOfTwoSortedArrays {
    /**
     * 4. Median of Two Sorted Arrays
     *
     * 求两个数组合并后的中位数，要求时间复杂度为log（m+n）
     *
     * 根据要求的时间复杂度，需要使用二分查找，对于中位数，有一些性质，中位数左边的元素个数等于右边元素个数，
     *
     * 设A的切分点为i   B的切分点为j  当两个切分点产生的数组前半段个数==数组后半段个数的时候，就是两个数组的切分点
     *
     * 当两个切分点合适的时候应该满足以下要求
     * (1) i + j == m - i + n - j + 1
     * (2) B[j-1] <= A[i] and A[i-1] <= B[j]
     *
     * 当两个数组元素和为偶数的时候  (max(A[i-1], B[j-1]) + min(A[i], B[j]))/2
     * 当两个数组元素个数和为奇数的时候  max(A[i-1], B[j-1])
     */
    public static double findMedianSortedArrays(int A[], int B[]) {

        int m=A.length;
        int n=B.length;
        int i=m/2;
        int j=(m+n+1)/2-i;//当m+n=偶数的时候 (m+n+1)/2-i==(m+n)/2-i  所以无需分类
        //判断切分点可能出现的几种情况
        while(!(B[j-1] <= A[i] && A[i-1] <= B[j])){
//            if(A[i]){
//
//            }i
        }


        return 0.1;

    }

}
