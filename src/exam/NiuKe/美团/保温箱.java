package exam.NiuKe.美团;

import java.util.*;

public class 保温箱 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
            count+=a[i];
        }
        //按照从大到小的顺序排列
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for(int i=0;i<n;i++){
            b[i]=in.nextInt();
            int[] temp=new int[]{b[i],i,a[i]};
            queue.add(temp);
        }

        //首先找出b中最大的几个元素  最少保温箱数
        int countTemp=0;
        int yuancountTemp=0;
        int xiagnzishu=0;
        while(countTemp<count){
            int[] t=queue.poll();
            xiagnzishu++;
            countTemp+=t[0];//最大容量
            yuancountTemp+=t[2];//原始的容量
        }
        //可知要选择xiagnzishu这么多个箱子

        combinationSum(b,0,xiagnzishu);

        System.out.println(String.valueOf(xiagnzishu)+String.valueOf(count-yuancountTemp));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target,int count) {
        List<List<Integer>> result=new ArrayList<>();
        if(candidates==null || candidates.length==0){
            return null;
        }
        Arrays.sort(candidates);//先排序
        List<Integer> list=new ArrayList<>();
        DFS(result,list,candidates,0,target,count);

        return result;
    }
    public static void DFS(List<List<Integer>> result,List<Integer> list,int[] nums,int index,int target,int count){
        //判断list中和是否满足要求
        int tempResult=0;
        if(list.size()==count){
            for(Integer temp:list){
                tempResult+=temp;
            }
        }

        if(tempResult==target){
            result.add(new ArrayList<>(list));
            return;
        }else if(tempResult>target){
            return;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            DFS(result, list,nums,i,target,count);
            list.remove(list.size()-1);
        }

    }
}
