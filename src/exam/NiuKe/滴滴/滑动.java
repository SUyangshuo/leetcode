package exam.NiuKe.滴滴;

import java.util.Scanner;

public class 滑动 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] a=new int[n];
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        dp[0]=0;
        for(int i=1;i<n+1;i++){
            dp[i]=dp[i-1]+a[i-1];
        }
        int min=Integer.MAX_VALUE;
        for(int i=m;i<n+1;i++){
            for(int j=m;j<n+1;j++){
                min=Math.min(min,dp[j]-dp[j-m]);
            }
        }
        System.out.println(min);
    }
}
