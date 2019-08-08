package exam.medium.Recurrence.dp.KnapsackProblem.Stock;

public class BestTimeToBuyAndSellStock {
    /**
     *  121:Best Time to Buy and Sell Stock
     *  题意解读：给定一个数组，数组的第i个元素是第i天的股票价格。
     *      如果你只允许进行一次买卖操作（买和买当做一次交易），设计一个算法寻找最大额收益
     *  重点：有多种解法
     *          方法一：分治法，寻找差值最大的两个点，有三种情况，第一种是都在左边，第二种是都在右边，然后是横跨左右
     *          方法二：传统方法，双重for循环
     *          方法三：dp  dp[i]表示的是0-i天内最大收益
     */
    //分治法--超时
    public  static int maxProfit1(int[] prices) {
        if(prices==null ||prices.length <= 0){
            return 0;
        }
        int result = div(prices,0,prices.length-1);
        return  result;
    }
    public static int div(int[] prices,int l,int r){
        if(l==r){
            return 0;//这种情况下就是同一天买，同一天卖，返回0即可
        }
        int mid=l+(r-l)/2;
        //找出左右两个的最大差值
        int min=Integer.MAX_VALUE;
        for(int i=l;i<=mid;i++){
            min=Math.min(min,prices[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=mid+1;i<=r;i++){
            max=Math.max(max,prices[i]);
        }
        int bonus=max-min;
        int leftBonus=div(prices,0,mid);
        int rightBonus=div(prices,mid+1,r);
        return  Math.max(Math.max(bonus,leftBonus),rightBonus);

    }
    //方法三：dp
    public int maxProfit31(int[] prices) {
        if(prices==null ||prices.length <= 0){
            return 0;
        }
        int[] dp=new int[prices.length];
        int min=prices[0];
        dp[0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            dp[i]=Math.max(dp[i-1],prices[i]-min);
        }
        return dp[prices.length-1];
    }
    //dp优化方案，只用一个空间
    public int maxProfit32(int[] prices) {

        int maxProfit = 0;

        int min = Integer.MAX_VALUE;

        for (int i : prices) {
            min = Math.min(min, i);
            maxProfit = Math.max(maxProfit, i - min);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a=new int[]{7,1,5,3,6,4};
        maxProfit1(a);

    }
}


