package exam.medium.Recurrence.dp.KnapsackProblem.Stock;

public class BestTimeToBuyAndSellStockII {
    /**
     * 122. Best Time to Buy and Sell Stock II
     * 可以交易任意次的股票，最大收益多少
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length<1){
            return 0;
        }
        int result=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-prices[i-1]>0){
                result+=prices[i]-prices[i-1];
            }
        }
        return result;
    }
}
