package exam.medium.Recurrence.dp.KnapsackProblem.Stock;

public class BestTimeToBuyAndSellStockIII {
    /**
     * 123. Best Time to Buy and Sell Stock III
     * 最多有两次机会可以买卖股票。求最大收益
     * 使用dp  使用两个数组  因为最多有两次买卖，所以需要两个二维dp
     *
     * local【i】【j】表示 到达第i天，最后一天必须卖出，最多j次交易的最大收益
     * global【i】【j】表示 到达第i天后，最多j次交易的最大收益，最后一天不要求是否交易
     *
     * @param prices
     * @return
     */

    /**
     * 相似题目：188. Best Time to Buy and Sell Stock IV

     * @param prices
     * @return
     */

    public static int maxProfit(int[] prices) {
        if(prices== null || prices.length<=0){
            return 0;
        }
        int[][] local=new int[prices.length][3];
        int[][] global=new int[prices.length][3];
        //每次新加入一个交易日，要对全部的交易记录变更
        for(int i=1;i<prices.length;i++){
            int diff=prices[i]-prices[i-1];//表示今天交易的收益
            for(int j=2;j>0;j--){
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(diff,0),local[i-1][j]+diff);
                global[i][j]=Math.max(local[i][j],global[i-1][j]);
            }

        }
        return global[prices.length-1][2];
    }
    //优化
    public static int maxProfit2(int[] prices) {
        if(prices== null || prices.length<=0){
            return 0;
        }
        int[] local=new int[3];
        int[] global=new int[3];
        //每次新加入一个交易日，要对全部的交易记录变更
        for(int i=1;i<prices.length;i++){
            int diff=prices[i]-prices[i-1];//表示今天交易的收益
            for(int j=2;j>0;j--){
                local[j]=Math.max(global[j-1]+Math.max(diff,0),local[j]+diff);
                global[j]=Math.max(local[j],global[j]);
            }

        }
        return global[2];
    }



    public static void main(String[] args) {
        int[] a=new int[]{3,3,5,0,0,3,1,4};
        maxProfit(a);
    }
}
