package exam.medium.Recurrence.dp;

public class CountingBits {
    /**
     * 338. Counting Bits 两星
     描述：给定n值，求0-n的所有数二进制表示有几个1
     重点：使用dp保存计算过的数，新进来的数/2如果有余数 那就是/2对应的数+1，如果没有余数就是那个数对应1的数量
     */
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 1; i <= num; i++) {
            if(i % 2 == 1) {
                result[i] = result[i>>1] + 1;
            } else {
                result[i] = result[i>>1];
            }
        }
        return result;
    }
}
