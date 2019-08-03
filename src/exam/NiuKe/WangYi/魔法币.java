package exam.NiuKe.WangYi;

import java.util.Scanner;

public class 魔法币 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        String result=solution(n);

        System.out.println(result);
    }
    public static String solution(int n){

        String[] dp=new String[n+3];
        dp[0]="0";
        dp[1]="1";
        dp[2]="2";
        for(float i=3;i<n+1;i++){
            if((i-1)/2==(int)(i-1)/2){
                dp[(int)i]=dp[(int)(i-1)/2]+"1";
            }else if((i/2-1)==((int)i/2-1)){
                dp[(int)i]=dp[(int)i/2-1]+"2";
            }
        }
        return dp[n];
    }
}
