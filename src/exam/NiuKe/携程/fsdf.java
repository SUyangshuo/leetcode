package exam.NiuKe.携程;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fsdf {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt(); in.hasNextLine();
        int m=in.nextInt();
        int[][] a=new int[m][];
        int[] used=new int[n];
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            int temp1=in.hasNextLine()?in.nextInt():null;
            int temp2=in.hasNextLine()?in.nextInt():null;
            int temp3=in.hasNextLine()?in.nextInt():null;
            Map<Integer,Integer> tempMap1=new HashMap<>();
            tempMap1.put(temp1,temp3);
            Map<Integer,Integer> tempMap2=new HashMap<>();
            tempMap2.put(temp2,temp3);
            if(map.containsKey(temp1)){
                map.get(temp1).put(temp2,temp3);
            }else {
                map.put(temp1,tempMap2);
            }
            if(map.containsKey(temp2)){
                map.get(temp2).put(temp1,temp3);
            }else{
                map.put(temp2,tempMap1);
            }
        }
        used[0]=1;
        solution(map,used,map.size()-1,0,0);
        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);

        }

    }
    public static void solution(Map<Integer,Map<Integer,Integer>> map,int[] used,int count,int index,int all){
        if(count==0 && map.get(0).containsKey(index)){//全部遍历完了
            min=Math.min(min,all+map.get(0).get(index));
            return;
        }
        for(Map.Entry<Integer,Integer> tempMap:map.get(index).entrySet()){
            if(used[tempMap.getKey()]==0){
                used[tempMap.getKey()]=1;
                all+=tempMap.getValue();
                solution(map,used,count--,tempMap.getKey(),all);
                count++;
                used[tempMap.getKey()]=0;
                all-=tempMap.getValue();
            }
        }

    }
}
