package exam.NiuKe.依图;

import java.util.*;

public class 蛋刀 {
    public static int allMin=Integer.MAX_VALUE;
    public static Map<Integer,Integer> allMap=new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();//城市
        int m=scanner.nextInt();//道路
        int s=scanner.nextInt();//出发
        int d=scanner.nextInt();//结束
        int[] dangao=new int[n];
        for(int i=0;i<n;i++){
            dangao[i]=scanner.nextInt();
        }
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        int[][] t=new int[m][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<3;j++){
                t[i][j]=scanner.nextInt();

            }
            Map<Integer,Integer> temp=new HashMap<>();
            temp.put(t[i][1],t[i][2]);
            map.put(t[i][0],temp);
        }
        //图深度优先遍历  带权值
        if(d==s){
            System.out.print("0"+" "+dangao[d-1]);
            return;
        }
        if(map.get(s).containsKey(d)){
            System.out.print(map.get(s).get(d)+" "+dangao[d-1]+dangao[s-1]);
            return;
        }

        List<Integer> list=new ArrayList<>();
        list.add(s);
        dfs(0,map,list,d,dangao);


        int result=0;
        if(allMap.containsKey(allMin)){
            result=allMap.get(allMin);
        }
        if(allMin==Integer.MAX_VALUE){
            allMin=0;
        }
        System.out.print(allMin+" "+result);

    }
    public static void dfs(int quanzhi, Map<Integer,Map<Integer,Integer>> map, List<Integer> list, int d,int[] dangao){
        if(!list.isEmpty() && list.get(list.size()-1)==d){

            if(allMin>quanzhi){
                allMin= quanzhi;
                quanzhi(new ArrayList<>(list),dangao);
            }

        }else {
            Map<Integer,Integer> tempmap=map.get(list.get(list.size()-1));
            for(Map.Entry<Integer,Integer> tt:tempmap.entrySet()){
                list.add(tt.getKey());
                quanzhi=quanzhi+tt.getValue();
                dfs(quanzhi,map,list,d,dangao);
                quanzhi=quanzhi-tt.getValue();
                list.remove(tt.getKey());
            }
        }

    }
    // 蛋糕数
    public static void quanzhi(List<Integer> list,int[] dangao){
        int count=0;
        for(Integer temp:list){
            count+=dangao[temp-1];
        }
        if(allMap.containsKey(allMin) && allMap.get(allMin)>count){
            allMap.put(allMin,count);
        }else if(!allMap.containsKey(allMin)){
            allMap.put(allMin,count);
        }

    }

}
