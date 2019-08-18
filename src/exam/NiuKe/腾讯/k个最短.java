package exam.NiuKe.腾讯;

import java.util.Map;
import java.util.Scanner;

public class k个最短 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length=in.nextInt();
        int k=in.nextInt();
        int[] a=new int[length];

        int count=0;
        for(int i=0;i<length;i++){
            a[i]=in.nextInt();
        }
        int index=0;

        //求数组中k个和最小
        int min=Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            count=0;
            if(i>=k){
                int j;
                for(j=i;j>i-k;j--){
                    count+=a[j];
                }
                if(count<min){
                    min= count;
                    index=j+2;
                }
            }
        }
        System.out.println(index);
    }
}
