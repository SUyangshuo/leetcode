package exam.NiuKe.滴滴;


import java.util.Scanner;

public class sdsadas {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int total=sc.nextInt();
        int cost=sc.nextInt();
        int[] num1=new int[n];
        int[] num2=new int[n];
        for(int i=0;i<n;i++) {
            num1[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            num2[i]=sc.nextInt();
        }
        int[][] dp=new int[n+1][n+1];
        int res=0;

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(num1[i-1]==num2[j-1]) {
                    dp[i][j]=Math.max(dp[i-1][j-1]+1,dp[i][j-1]);
                }else {
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(Math.min(total/cost, dp[n][n]));
    }
}