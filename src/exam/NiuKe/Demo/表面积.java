package exam.NiuKe.Demo;

import java.util.Scanner;

public class 表面积 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i=0;

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] index=new int[n][m];
        for(int j=0;j<n;j++){
            for(int x=0;x<m;x++){
                index[j][x]=in.nextInt();
            }
        }





        int count=0;
        for(int j=0;j<n;j++){
            for(int x=0;x<m;x++){
                //第一行
                if(j==0){
                    //左上
                    if(j==0 && x==0){
                        if(index[0][0]>index[0][1]){
                            count=count+index[0][0]-index[0][1];
                        }
                        if(index[0][0]>index[1][0]){
                            count=count+index[0][0]-index[1][0];
                        }
                        count=count+index[j][x]*2;
                    }else if(j==0 && x==m-1){
                        if(index[j][x]>index[j][x-1]){
                            count=count+index[j][x]-index[j][x-1];
                        }
                        if(index[j][x]>index[j+1][x]){
                            count=count+index[j][x]-index[j+1][x];
                        }
                        count=count+index[j][x]*2;
                    }  else {
                        if(index[j][x]>index[j][x-1]){
                            count=count+index[j][x]-index[j][x-1];
                        }
                        if(index[j][x]>index[j+1][x]){
                            count=count+index[j][x]-index[j+1][x];
                        }
                        if(index[j][x]>index[j][x+1]){
                            count=count+index[j][x]-index[j][x+1];
                        }
                        count=count+index[j][x];

                    }
                }else if(j==n-1){
                    //左下
                    if(j==n-1 && x==0){
                        if(index[j][x]>index[j-1][x]){
                            count=count+index[j][x]-index[j-1][x];
                        }
                        if(index[j][x]>index[j][x+1]){
                            count=count+index[j][x]-index[j][x+1];
                        }
                        count=count+index[j][x]*2;
                    }else if(j==n-1 && x==m-1){
                        if(index[j][x]>index[j-1][x]){
                            count=count+index[j][x]-index[j-1][x];
                        }
                        if(index[j][x]>index[j][x-1]){
                            count=count+index[j][x]-index[j][x-1];
                        }
                        count=count+index[j][x]*2;
                    }else {
                        if(index[j][x]>index[j][x-1]){
                            count=count+index[j][x]-index[j][x-1];
                        }
                        if(index[j][x]>index[j-1][x]){
                            count=count+index[j][x]-index[j-1][x];
                        }
                        if(index[j][x]>index[j][x+1]){
                            count=count+index[j][x]-index[j][x+1];
                        }
                        count=count+index[j][x];

                    }

                }else if (x==0) {
                    if(index[j][x]>index[j][x+1]){
                        count=count+index[j][x]-index[j][x+1];
                    }
                    if(index[j][x]>index[j-1][x]){
                        count=count+index[j][x]-index[j-1][x];
                    }
                    if(index[j][x]>index[j+1][x]){
                        count=count+index[j][x]-index[j+1][x];
                    }
                    count=count+index[j][x];

                }else if(x==m-1){
                    if(index[j][x]>index[j][x-1]){
                        count=count+index[j][x]-index[j][x-1];
                    }
                    if(index[j][x]>index[j-1][x]){
                        count=count+index[j][x]-index[j-1][x];
                    }
                    if(index[j][x]>index[j+1][x]){
                        count=count+index[j][x]-index[j+1][x];
                    }
                    count=count+index[j][x];

                }else {
                    if(index[j][x]>index[j][x-1]){
                        count=count+index[j][x]-index[j][x-1];
                    }
                    if(index[j][x]>index[j-1][x]){
                        count=count+index[j][x]-index[j-1][x];
                    }
                    if(index[j][x]>index[j+1][x]){
                        count=count+index[j][x]-index[j+1][x];
                    }
                    if(index[j][x]>index[j][x+1]){
                        count=count+index[j][x]-index[j][x+1];
                    }

                }


            }
        }
        System.out.println(count+(m*n)*2);

    }
}
