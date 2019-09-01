package exam.medium.Find.DinarySearch;

public class KthSmallestNumberInMultiplicationTable {
    /**
     * 668. Kth Smallest Number in Multiplication Table
     * 寻找m*n乘法表中前k个最小的数
     *
     * 可知左上角和右下角的两个值分别hi最大值和最小值，找到最大值和最小值的中间值，
     * 判断小于中间值的个数和k值的关系，然后进行收缩
     *
     */
    public int findKthNumber(int m, int n, int k) {
        int st = 1, ed = m * n;
        while (st < ed) {
            int mid = (st + ed) / 2;
            if (largeEnough(mid, m, n, k)) {
                ed = mid;
            }else st = mid + 1;
        }
        return ed;
    }
    private boolean largeEnough(int x, int m, int n, int k) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += Math.min(x / i, n);//乘法表中每一行最多n个元素
         }
        return cnt >= k;
    }

}
