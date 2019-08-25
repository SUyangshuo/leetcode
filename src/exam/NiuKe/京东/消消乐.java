package exam.NiuKe.京东;

import java.util.List;
import java.util.Scanner;

public class 消消乐 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a=new int[5][5];
        List[] lists=new List[5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                a[i][j]=scanner.nextInt();

            }
        }
        //5表示一个，6表示两个，7表示三个
        int[][] b=new int[5][5];
        b[0][0]=5;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(i!=0){//不是第一行先判断左边列
                    if(b[j][i-1]==5 && a[j][i]==a[j][i-1]){
                        b[j][i-1]=6;
                    }else if(b[j][i-1]==6 && a[j][i]==a[j][i-1]){
                        b[j][i-1]=7;
                    }else if(b[j][i-1]==7 && a[j][i]==a[j][i-1]){
                        b[j][i-1]=7;
                    }else{
                        b[j][i-1]=5;
                    }
                }
                if(j-1>=0){
                    if(b[j-1][i]==5  && a[j][i]==a[j-1][i]){
                        b[j][i]=6;
                    }else if(b[j-1][i]==6 && a[j][i]==a[j-1][i]){
                        b[j][i]=7;
                    }else if(b[j-1][i]==7 && a[j][i]==a[j-1][i]){
                        b[j][i]=7;
                    }else if(a[j-1][i]!=a[j][i]){
                        b[j][i]=5;
                    }
                }
            }
        }

        System.out.print(3);
    }
    public static void dfs(List[] lists,int[][] a) {
       for(int i=0;i<5;i++){
           for(int j=0;j<5;j++){
               if(a[i][j]==7){
                   a[i][j]=0;
               }
           }
       }
    }
}
