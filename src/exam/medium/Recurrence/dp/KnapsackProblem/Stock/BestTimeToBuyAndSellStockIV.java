package exam.medium.Recurrence.dp.KnapsackProblem.Stock;

public class BestTimeToBuyAndSellStockIV {
    /**
     * 188. Best Time to Buy and Sell Stock IV
     * 该题为第二题和第三题结合
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if(prices== null || prices.length<=0){
            return 0;
        }


        int[][] local=new int[prices.length][k+1];
        int[][] global=new int[prices.length][k+1];

        if(k>prices.length){
            int result=0;
            for(int i=1;i<prices.length;i++){
                if(prices[i]-prices[i-1]>0){
                    result+=prices[i]-prices[i-1];
                }
            }
            return result;
        }
        //每次新加入一个交易日，要对全部的交易记录变更
        for(int i=1;i<prices.length;i++){
            int diff=prices[i]-prices[i-1];//表示今天交易的收益
            for(int j=k;j>0;j--){
                local[i][j]=Math.max(global[i-1][j-1]+Math.max(diff,0),local[i-1][j]+diff);
                global[i][j]=Math.max(local[i][j],global[i-1][j]);
            }

        }
        return global[prices.length-1][k];


    }
}
