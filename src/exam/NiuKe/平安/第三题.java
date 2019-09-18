package exam.NiuKe.平安;

import java.util.Scanner;

public class 第三题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            count+=a[i];
        }
        int avg=0;
        if(count%n>0){
            System.out.println(-1);
            return;
        }else {
            avg=count/n;
        }
        int result=0;
        //查看每一个位置和平均值的差是不是2的倍数
        int temp=0;//欠债
        for(int i=0;i<n;i++){
            if(Math.abs(a[i]-avg)%2!=0){
                System.out.println(-1);
                return;
            }
            if(a[i]>avg){
                temp+=a[i]-avg;
                result+=(a[i]-avg)/2;
            }else if(a[i]<avg){
                temp-=avg-a[i];
            }
        }
        if(temp==0){
            System.out.println(result);
        }else {
            System.out.println(-1);
        }

    }
}
