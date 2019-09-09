package exam.NiuKe.今日;

import java.util.Scanner;

public class 第一题 {
    public static  int max=Integer.MIN_VALUE;
    public static  int index=0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            int count=0;
            int temp=0;  //表示比a【i】小  但是比其他元素大的 次最大
            for(int j=i+1;j<n;j++){
                if(a[j]>=a[i] || j==n-1){//出现比a【i】大的元素 或者是到最后一个
                    if(a[j]==a[i] || (a[j]<=a[i] && a[j]>temp)){
                        count++;
                    }
                    if(count>max){
                        max=Math.max(count,max);
                        index=i;
                    }
                    break;
                }
                if(a[j]>temp && a[j]<a[i]){
                    temp=a[j];
                    count++;
                    continue;
                }
            }
        }
        System.out.println(a[index]);


    }
}
