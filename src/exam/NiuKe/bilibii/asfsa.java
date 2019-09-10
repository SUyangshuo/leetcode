package exam.NiuKe.bilibii;

import java.util.Scanner;

public class asfsa{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int s=in.nextInt();

        int[] a=new int[n];
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        for(int i=1;i<n+1;i++){
            dp[i]=dp[i-1]+a[i-1];
        }
        boolean index=true;
        for(int i=1;i<=n;i++){
            int l=0,r=l+i;
            for(int y=r;y<=n;y++){
                if(i==1){
                    if(a[i]>=s){
                        System.out.println(1);
                        index=false;
                        break;
                    }
                }else{
                    if(dp[y]-dp[y-i]>=s){
                        System.out.println(i);
                        index=false;
                        break;
                    }
                }
            }
            if(!index){
                break;
            }
        }

    }
}
