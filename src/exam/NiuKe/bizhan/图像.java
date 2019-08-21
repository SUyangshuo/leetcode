package exam.NiuKe.bizhan;
import java.util.Scanner;

public class 图像 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int h=in.nextInt();
        int w=in.nextInt();
        int[][] tu=new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                tu[i][j]=in.nextInt();
            }
        }
        int m=in.nextInt();
        double[][] juanji=new double[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                juanji[i][j]=in.nextDouble();
            }
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                System.out.print(fun1(tu,juanji,i,j,m) + " ");
            }
            System.out.println();
        }
    }


    public static int fun1(int[][] P, double[][] K, int i, int j, int m){

        double result = 0;

        for(int x = 0; x < m; x++){
            for(int y = 0; y < m; y++){
                result = P[i+x][j+y] * K[x][y];
                if(result < 255){
                    return (int)Math.floor(result);
                }else {
                    return 255;
                }

            }
        }

        if(result < 255){
            return (int)Math.floor(result);
        }else {
            return 255;
        }


    }


}