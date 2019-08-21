package exam.NiuKe.小红书;

import java.util.Scanner;

public class 笔记 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int countZ=0;

        for(int i=0;i<n;i++){
            int temp=in.nextInt();

                a[i]=temp;
                if(temp==0){
                    countZ++;
                }

        }
        if(n==2){
            int result=Math.max(a[0],a[1]);
            if(result==0){
                System.out.print(result+" "+0);
                return;
            }else{
                System.out.print(result+" "+1);
                return;
            }

        }else if(n==1){
            if(a[0]==0){
                System.out.print(0+" "+0);
                return;
            }else{
                System.out.print(a[0]+" "+1);
                return;
            }
        }else if(n==0){
            System.out.print(0+" "+0);
            return;

        }

        int[] dp=new int[n];//dp[i]表示到i的最大点赞数
        dp[0]=a[0];
        dp[1]=Math.max(a[1],a[0]);

        //只有一个或者只有两个
        ///

        int count=0;

        for(int i=2;i<n;i++){
            if(a[i]==0){
                countZ++;
            }

            dp[i]=Math.max(dp[i-2]+a[i],dp[i-1]);
        }
        n=n-countZ;
        if(n%2==1){
            if(dp[dp.length-1]==dp[dp.length-2]){
                count=n/2;
            }else{
                count=n/2+1;
            }
        }else if(n%2==0){
            count=n/2;
        }
        System.out.print(dp[dp.length-1]+" "+count);

    }
}
