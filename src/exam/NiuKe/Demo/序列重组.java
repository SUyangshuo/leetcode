package exam.NiuKe.Demo;

import java.util.*;

public class 序列重组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int n = in.nextInt();
        int m = in.nextInt();
        int[] temp1=new int[n];
        int[] temp2=new int[n];
        Map<Integer,Integer> map1=new HashMap();
        Map<Integer,Integer> map2=new HashMap();

         for(int x=0;x<n;x++){
                int temp=in.nextInt();
                if(map1.containsKey(temp)){
                    map1.put(temp, map1.get(temp)+1);
                }else{
                    map1.put(temp, 1);
                }

         }
        for(int x=0;x<n;x++){
            int temp=in.nextInt();
            if(map2.containsKey(temp)){
                map2.put(temp, map1.get(temp)+1);
            }else{
                map2.put(temp, 1);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> temp:map1.entrySet()){
             int tempCount=0;

             if(map2.containsKey(m-temp.getKey())){
                 tempCount=m-1;
                 list.add(tempCount);
             }else {
//                 for(Map.Entry<Integer,Integer> temp:map1.entrySet()){
//
//                 }
             }


        }




    }
}
