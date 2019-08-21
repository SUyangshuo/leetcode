package exam.NiuKe.bizhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 组合 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        char[] newi=String.valueOf(n).toCharArray();

        int[] dp=new int[newi.length+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<newi.length+1;i++){
            if(newi[i-1]-'0'==0){
                dp[i]=dp[i-2];
                continue;
            }
            int temp=Integer.valueOf(String.valueOf(newi[i-2])+String.valueOf(newi[i-1]));

            if(temp<=26 && temp>=10 && i==2){
                dp[i]=2;
            }else if(temp<=26 && temp>=10 ){
                dp[i]=dp[i-2]+dp[i-1];
            }else{
                dp[i]=dp[i-1];
            }
        }
        System.out.print(dp[newi.length]);

    }
}
