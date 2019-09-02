package exam.medium.Array;

public class CouplesHoldingHands {
    /**
     * 765. Couples Holding Hands
     * 一个乱序数组，需要交换任意两个位置，使数组元素结对 结对的原则是0-1  2-3  4-5  6-7.。。。。前后顺序可以交换 只要一队数据挨着即可
     *
     * 重点：方法一：贪心，不过不好证明。从位置0开始，看位置1是否是它的partner，如果是，直接忽略这组couple，
     *      如果不是，从后面的数组中，找到partner直接交换，并且记录交换次数一次。遍历完整个数组即为最优解。
     *
     */
    //方法一：不知奥怎么证明
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            int dest;
            //这一步判断该数是奇数还是偶数
            if ((row[i] & 1) == 0) dest = row[i] + 1;
            else dest = row[i] - 1;
            //说明前后是匹配的
            if (row[i + 1] == dest) continue;
            ans ++;

            //向后遍历寻找搭档
            for (int j = i + 2; j < n; ++j) {
                if (row[j] == dest) {
                    int tmp = row[i + 1];
                    row[i + 1] = row[j];
                    row[j] = tmp;
                    break;
                }
            }
        }
        return ans;
    }

}
