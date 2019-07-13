package exam.easy1;

import java.util.Scanner;

public class Stone {
	public static void main(String[] args) {
		  Scanner scn = new Scanner(System.in);
		     // System.out.println("请输入总球的个数和要取的球的个数");
		      int m = scn.nextInt();//几个列
		      int[] tmp=new int[m];
		      
		      for(int n=0;n<m;n++){
		    	  int tt1 = scn.nextInt();
		    	  tmp[n]=tt1;
		      }
	}
	public static void solution(int k){
		if((k & (k-1)) == 0){
			
		}
		if(k==3){
			System.out.println("don't be discouraged");
		}
		if(k%2==1){
			System.out.println("lucky");
		}
		
	}
	
}
