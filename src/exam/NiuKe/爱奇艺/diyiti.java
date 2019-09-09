package exam.NiuKe.爱奇艺;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class diyiti {
    public static long count;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] bijiao=new int[n-1];//排序组合的第一个元素是从1开始
        bijiao[0]=-1;
        Integer[] a=new Integer[n];//排列组合  排列组合的第一个元素是从1开始
        a[n-1]=n-1;
        for(int i=0;i<n-1;i++){
            bijiao[i]=in.nextInt();
            a[i]=i;
        }
        List<Integer[]> result=new ArrayList<>();
        dfs(new ArrayList<>(), a, new boolean[a.length],bijiao);

        long tt= (long)Math.pow(10,9)+7;
        System.out.println(count%tt);
//        System.out.println(2);


    }

    public static   List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

    public static  void dfs( List<Integer> temp, Integer[] nums, boolean[] used,int[] bijiao) {
        if (temp.size() == nums.length) {
            //判断temp是否符合要求
            List<Integer> t=new ArrayList<>(temp);
            if(judge(t,bijiao)){
                count++;
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//记录某个下标的数是否被使用过
                temp.add(nums[i]);
                used[i] = true;
                dfs(temp, nums, used,bijiao);
                temp.remove(temp.size() - 1); //移除最后一个
                used[i] = false;
            }
        }
    }



    public static boolean judge( List<Integer> a,int[] bijiao){
        for(int i=0;i<bijiao.length;i++){
            if(bijiao[i]==1 && a.get(i)<=a.get(i+1)){//说明i》i+1
                return false;
            }
            if(bijiao[i]==0 && a.get(i)>=a.get(i+1)){
                return false;
            }
        }
        return true;
    }
}
