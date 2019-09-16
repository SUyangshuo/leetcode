package exam.NiuKe.wuba;

import java.util.Scanner;

public class dier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int count=0;
        System.out.println(10);
        int temp=-1;
        for(int i=0;i<n;i++){
            if(i==0 && a[0]<a[1]){
                temp=0;
                    count++;
                    continue;
            }
            if(i==n-1 && a[i]<a[i-1]){
                temp=n-1;
                count++;
                continue;
            }

            if(a[i]<a[i-1] && a[i]<a[i+1] || i==n-1){
                count++;
            }

        }

    }
    public static int solution(int n){
        return ((n*(n+1))/2)-1;


    }
}
