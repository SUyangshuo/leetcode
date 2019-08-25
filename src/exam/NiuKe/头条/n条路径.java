package exam.NiuKe.头条;

import java.util.Scanner;

public class n条路径 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] dp=new int[n/2+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        //dp[3]=5;
        if(n==0){
            System.out.println(0);
            return;
        }
        if(n==2){
            System.out.println(1);
            return;
        }
        if(n==4){
            System.out.println(2);
            return;
        }
        for(int i=3;i<=n/2;i++){
            int temp1=dp[i-1]*2;
            int l=1,r=i-2;
            int count=temp1;
            while(l<r){
                count=count+2*dp[l]*dp[r];
                l++;
                r--;
            }
            if(l==r){
                count+=dp[l]*dp[l];
            }
            dp[i]=count;
        }
        System.out.println(dp[n/2]);

    }
}
