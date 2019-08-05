package exam.NiuKe.WangYi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 倒数排列 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
//        Scanner sc2 =new Scanner(System.in);
//        String string=sc2.nextLine();

        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
            int tt=sc.nextInt();
            a[i]=tt;
            b[i]=i+1;
        }


        List<List<Integer>> list=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        dfs2(list,tempList,b,new boolean[n],a,count);
//        int count=dfs(list,b,0,a,1);

        for(Integer temp:list.get(list.size()-count.get(0))){
            System.out.print(temp+" ");
        }


    }

 
    public static  void dfs2(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used,int[] a,List<Integer> count) {
        if (temp.size() == nums.length) {
            boolean index=true;
            for (int i =0;i<nums.length;i++) {
                if (index && a[i] != temp.get(i)){
                    index=false;
                }
            }
            if(index){
                count.add(res.size()+1);
            }
            //注意不能直接添加temp
            res.add(new ArrayList<>(temp)); //以一个集合或数组初始化ArrayList al = new ArrayList(a);//a为集合或数组
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//记录某个下标的数是否被使用过
                temp.add(nums[i]);
                used[i] = true;
                dfs2(res, temp, nums, used,a,count);
                temp.remove(temp.size() - 1); //移除最后一个
                used[i] = false;
            }
        }

    }

}
