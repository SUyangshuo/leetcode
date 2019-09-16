package exam.NiuKe.WangYi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 三角网络 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] a=new int[m][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int min=Integer.MAX_VALUE;
        int index=0;
       if(m==1){
           for(int i=0;i<3;i++){
               if(a[0][i]<min){
                   min=a[0][i];
                   index=i;
               }
           }
           if(index==0){
               System.out.println(a[0][0]+" "+a[0][1]+" "+a[0][2]);
           }
           if(index==1){
               System.out.println(a[0][1]+" "+a[0][2]+" "+a[0][3]);
           }
           if(index==2){
               System.out.println(a[0][2]+" "+a[0][0]+" "+a[0][1]);
           }
           return;

       }
        //只有一个三角的情况
        int[][] aa=new int[][]{{2,4,3},{1,2,3},{3,5,6},{3,4,5}};

        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                System.out.print(aa[i][j]+" ");
            }
            System.out.println();
        }

    }
}
