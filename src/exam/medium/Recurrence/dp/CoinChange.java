package exam.medium.Recurrence.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {
    /**
     * 322. Coin Change
     * 给定一串数组表示面额，一个整数，求用最少张的钱表示整数，无法表示的时候返回-1
     *
     * 方法一：使用传统方法从最大面额遍历---失败
     * 方法二：dp
     */
    public static void main(String[] args) {
        int[] a = new int[]{186,419,83,408};


        solution2(a,6249);
    }
    /**
     * 方法二：使用dp
     * 使用dp是要考虑的是递推式，dp问题是从结果推断原始，
     * 这个问题是由i个面额 amount总量
     */
    public static int solution2(int[] coins, int amount){
        //预排序
        //dp[i][j]表示的是面额为j的时候需要i种面额  最少多少个
        //todo:+1的原因是考虑到amount为0 面额为0个的情况
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<amount+1;i++){
            //注意这里不能使用最大值，使用最大值的话 +1后超出表示范围
            dp[0][i]=Integer.MAX_VALUE-1;
        }

        //先对硬币集合排序
        Arrays.sort(coins);
        /**
         * 递推式
         * 当前面额可以选择使用或者不使用，
         *      不使用的情况下 dp[i][j]==dp[i-1][j]
         *      使用的情况下dp[i][j]==dp[i][j-coins[i]]+1  这-1的原因是因为第i个面额 在coins中对应的位置是i-1
         *
         *      这两种情况取最小值
         */
        //按列遍历
        for(int i =1;i<amount+1;i++){ //总和 （列）
            for(int j=1;j<coins.length+1;j++){   //面额（行）
                if(coins[j-1]<=i){

                    dp[j][i]=Math.min(dp[j-1][i],dp[j][i-coins[j-1]]+1);
                }else{
                    dp[j][i]=dp[j-1][i];
                }
            }
        }

        return dp[coins.length][amount]>amount || dp[coins.length][amount]<0 ?-1:dp[coins.length][amount];

    }
    //dp优化  使用一维数组即可
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin: coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
            }
        }
        return (dp[amount] != Integer.MAX_VALUE -1) ? dp[amount] : -1;


    }





    //方法一 ---失败，问题在于忘记了 并不是从面值高向下遍历，右的高面额可能用不到  这道题用dp
    public static int solution(int[] coins, int amount){
        Arrays.sort(coins);
        int moneyCount=0;
        moneyCount=coinChange(coins,amount,moneyCount,coins.length-1);
        return moneyCount;
    }

    public static int  coinChange(int[] coins, int amount,int moneyCount,int index) {
       if(amount==0){
           return moneyCount;
       }

        while(index>-1 && coins[index]>amount){
            index--;
        }
        if(index==-1){
           return -1;
        }
        moneyCount=moneyCount+(amount/coins[index]);
        amount=amount%coins[index];
        moneyCount=coinChange(coins,amount,moneyCount,index);

        return moneyCount;
    }
}
