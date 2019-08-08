package exam.medium.Recurrence.dp.KnapsackProblem.Stock;

public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * 309. Best Time to Buy and Sell Stock with Cooldown
     * 给你N天股票的价格，设计一个算法求最大利润，并且一次交易完成之后，才能进行下一次交易，
     * 另外还加了条件，就是在你卖了之后，还有一天的冷却期，冷却器是不能进行交易的。
     *
     * 在第i天买一支股票还能剩下的利润＝第(i-2)天销售能够剩余的利润－第i天股票的价钱．
     在第i天卖一支股票总的利润＝第(i-1)天买股票剩下的最大利润＋当前股票的价格．

     也就是说需要维护两个状态的信息，一个是买股票所得到的剩余最大利润，一个是卖出股票之后得到的最大利润，
     他们互相依赖对方的信息．对于买来说，当天是否买取决于买了之后是否比之前买所剩余的利润大，即状态转移方程为：
     buy[i] = max(buy[i-1], sell[i-2] - prices[i-1]);

     对于卖来说，同样当天是否将这只股票卖掉取决于卖掉能否获得更大的利润，状态转移方程为：
     sell[i] = max(sell[i-1], buy[i-1] + prices[i-1]);

     *
     */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int[] buy=new int[prices.length+1];
        int[] sell=new int[prices.length+1];
        buy[1]=-prices[0];
        sell[1]=Integer.MAX_VALUE;
        for(int i=2;i<buy.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i-1]);

        }
        return sell[prices.length];
    }
}
