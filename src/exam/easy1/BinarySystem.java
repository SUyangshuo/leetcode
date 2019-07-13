package exam.easy1;

import java.util.ArrayList;
import java.util.List;

public class BinarySystem {
	private static List<List<Integer>> res = new ArrayList<>();
	public static void main(String[] args) {
		//solution();//问题1
		
		int[] tt={2,3,6,7};
		// [2,3,5], target = 8
		combinationSum(tt,7);
		for(List<Integer> list:res){
			for(int i:list){
				System.out.print(i);
			}
			System.out.println();
		}
		
	}
	/*计算某个整数二进制表示中的1表示的个数
	 * 要求时间复杂度为o（n），空间复杂度为o（n）
	 */
	public static void solution(){
		int a=5;
		int[] tmp=new int[a+1];//保存数组中每个数字的信息
		tmp[0]=0;
		for(int i=1;i<a+1;i++){
			int mid=i/2;
			if(i%2==0){//如果该数是偶数则该数二进制中1的个数和该数一半的数中的1的个数相同
				tmp[i]=tmp[mid];
			}else if(i%2==1){
				tmp[i]=tmp[mid]+1;
			}
		}
		for(int i:tmp){
			System.out.println(i);
		}
	}
	/*
	 * 给定一个k和一个数组，查找数组中哪两个数相加等于k
	 */
	
	 
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	         List<Integer> temp = new ArrayList<Integer>();
	          help(temp,candidates,0,0,target);
	          return res;
	      }
	 private static void help(List<Integer> temp,int[] nums,int index,int cursum,int target){
	          if(cursum>target)
	             return;
	         if(cursum==target)
	             res.add(new ArrayList<Integer>(temp));
	         for(int i = index;i<nums.length;i++){
	             temp.add(nums[i]);
	             help(temp,nums,i,cursum+nums[i],target);
	             temp.remove(temp.size()-1);
	         }
	     }
}
