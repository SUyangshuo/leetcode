package exam.NiuKe.爱奇艺;

import java.util.Scanner;

public class afsdf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] bijiao = new int[n];//排序组合的第一个元素是从1开始
        bijiao[0] = -1;
        Integer[] a = new Integer[n];//排列组合  排列组合的第一个元素是从1开始
        a[n - 1] = n - 1;
        bijiao[n - 1] = 3;
        String string="";
        for (int i = 0; i < n - 1; i++) {
            bijiao[i] = in.nextInt();
            string=string+String.valueOf(bijiao[i]);
            a[i] = i;
        }
        System.out.println(numPermsDISequence(string));

    }
    public static int numPermsDISequence(String S) {
        int len = S.length(), N = len + 1, mod = 1000000007;
        int[][] dp = new int[N+1][N];

        for(int i = 0; i < N; i++) dp[1][i] = 1;

        for(int i = 1; i <= len; i++) {
            if(S.charAt(i-1) == '1') for(int j = N - i -1; j >= 0; j--) dp[i+1][j] = (dp[i+1][j+1] + dp[i][j+1])%mod;
            else  for(int j = 0; j <= N - i-1; j++) dp[i+1][j] = ((j > 0 ? dp[i+1][j-1] : 0) + dp[i][j])%mod;
        }

        return dp[N][0];
    }
}
