package exam.NiuKe.携程;

import java.util.*;

public class 车辆时刻表分组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string=in.nextLine();
        TreeMap<Character,Integer[]> map=new TreeMap<>();

        for(int i=0;i<string.length();i++){
            if(!map.containsKey(string.charAt(i))){//第一次出现目的地  数组记录第一次和最后 一次出现的位置
                Integer[] temp=new Integer[2];
                temp[0]=i;
                temp[1]=i;
                map.put(string.charAt(i),temp);
            }else {
                Integer[] temp=map.get(string.charAt(i));
                temp[1]=i;
                map.put(string.charAt(i),temp);
            }
        }
        Integer[] temp=map.get(string.charAt(0));
        map.remove(string.charAt(0));
        for(Map.Entry<Character,Integer[]> tempMap:map.entrySet()){
            Integer[] value=tempMap.getValue();
            if(value[0]<temp[1]){//前后存在交叉  交叉有两种情况

                if(value[1]<temp[1]){
                    continue;
                }else {
                    temp[1]=value[1];
                    continue;
                }
            }
            if(value[0]>temp[1]){//没有交叉
                System.out.print(temp[1]-temp[0]+1+",");
                temp[0]=value[0];
                temp[1]=value[1];
            }
        }
        System.out.print(temp[1]-temp[0]+1);
    }
}
