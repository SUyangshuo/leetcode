package exam.medium.Recurrence.DFS.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    /**
     * 39. Combination Sum
     * 给定一个数组，求数组中的数组合成target  可以使用重复数字
     *
     * 重点：方法一：使用dfs 深度优先遍历
     *
     */
    //方法一：回溯 有边界的dfs
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(candidates==null || candidates.length==0){
            return null;
        }
        Arrays.sort(candidates);//先排序
        List<Integer> list=new ArrayList<>();
        DFS(result,list,candidates,0,target);

        return result;
    }
    public static void DFS(List<List<Integer>> result,List<Integer> list,int[] nums,int index,int target){
        //判断list中和是否满足要求
        int tempResult=0;
        for(Integer temp:list){
            tempResult+=temp;
        }
        if(tempResult==target){
            result.add(new ArrayList<>(list));
            return;
        }else if(tempResult>target){
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            DFS(result, list,nums,i,target);
            list.remove(list.size()-1);
        }

    }
    //方法一优化：
    //每次将target减 去nums【i】的值作为新的target
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        combinationSumHelp(candidates,result,list,target,0);
        return result;
    }

    public boolean combinationSumHelp(int[] candidates,List<List<Integer>> result,List<Integer> list,int target,int start){
        if(target<0){
            return false;
        }else if(target==0){
            List<Integer> temp = new ArrayList<Integer>(list);
            result.add(temp);
            return false;
        }else{
            for(int i = start; i < candidates.length ; i++){
                list.add(candidates[i]);
                boolean flag = combinationSumHelp(candidates,result,list,target-candidates[i],i);
                list.remove(list.size()-1);
                if(!flag){
                    break;
                }
            }
        }
        return true;
    }
    //方法二：dp只能计算出有多少组合数
    public static int combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(candidates==null || candidates.length==0){
            return -1;
        }
        Arrays.sort(candidates);//先排序
        int[] dp=new int[target+1];
        DP(dp,candidates,target);

        return dp[target];
    }

    public static void DP(int[] dp,int[] nums,int target){
        //使用双重循环dp
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=0;j-- ){//注意循环顺序是从后往前，避免重复
                if(j%nums[i]==0){
                    dp[j]++;
                }else if(j%nums[i]!=0  && j-nums[i]>=0 ){
                    dp[j]=dp[j]+dp[j-nums[i]];
                }
            }
        }

    }


    public static void main(String[] args) {

        combinationSum2(new int[]{2,3,6,7},7);
    }





}
