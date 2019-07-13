package exam.easy1;
import java.util.Scanner;

public class Combination {

	 public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	     // System.out.println("请输入总球的个数和要取的球的个数");
	      int m = scn.nextInt();//几个列
	      int[][] tmp=new int[m][2];
	      
	      for(int n=0;n<m;n++){
	    	  int tt1 = scn.nextInt();
	    	  tmp[n][0]=tt1;
	    	  int tt2 = scn.nextInt();
	    	  tmp[n][1]=tt2;
	    	  //System.out.println(tmp[n][0],tmp[n][1]);
	      }
	      
	      for(int z=0;z<m;z++){
	    	  int t=f(tmp[z][0],tmp[z][1]);
	    	  System.out.println(t);
	      }
	     
	     
	  }

	  public static int f(int m, int n) {
		  if(m<n){
	          return 0;
	      }
	      if(m==n){
	          return 1;
	      }
	      if(n==0){
	          return 1;
	      }
	      
	      //假设有一个特殊球,有两种情况,从除特殊球剩下的球中，取n个球，另一种一定不取特殊球
	      return f(m-1,n)+f(m-1,n-1);
	  }
}



//已知有m个球，从中取n个球，请问有多少种不同的取法
