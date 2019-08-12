package exam.medium.Recurrence.DFS;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3};
        Solution solution =new Solution();
        solution.subsets2(a);
    }
}
/**
 * 78. Subsets
 * 求给定数组的全部子集
 */
class Solution{

    /**
     * 普通递归---速度慢
     * 很容易超时，需要减少无效判断，
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Map<String,List<Integer>> map=new HashMap<>();
        boolean[] used=new boolean[nums.length];
        List<Integer> list=new ArrayList<>();

        map=DFS(nums,used,list,map);


        for(Map.Entry<String,List<Integer>> temp:map.entrySet()){
            result.add(temp.getValue());
            System.out.println(temp.getValue());
        }

        return result;
    }
    public Map<String,List<Integer>> DFS(int[] nums,boolean[] used,List<Integer> list,Map<String,List<Integer>> map){
        String string="";
        //先对list排序
        List<Integer> tempList=new ArrayList<>();
        tempList.addAll(list);
        Collections.sort(tempList);
        for(Integer temp:tempList){
            string=string + String.valueOf(temp);
        }
        if(!map.containsKey(string)){
            map.put(string,tempList);
        }else{
            return map; //减少无效计算
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                list.add(nums[i]);
                used[i]=true;
                DFS(nums,used,list,map);
                list.remove(list.size()-1);
                used[i]=false;
            }
        }
        return map;
    }
    /**
     * 改进，优化时间复杂度
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();

        List<Integer> list=new ArrayList<>();
        DFS2(nums,result,list,0);

        return result;
    }
    public void DFS2(int[] nums,List<List<Integer>> result,List<Integer> list,int index){
        result.add(new ArrayList<Integer>(list));
        for(int i=index;i<nums.length;i++){

            DFS2(nums,result,list,i+1);
            list.remove(list.size()-1);
        }
        return;
    }



}
