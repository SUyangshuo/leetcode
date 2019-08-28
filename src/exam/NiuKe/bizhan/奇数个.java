package exam.NiuKe.bizhan;

import java.util.HashMap;
import java.util.Map;

public class 奇数个 {
    /**
     * 查找数组中唯一的奇数个元素
     * @param args
     */
    public static void main(String[] args) {

    }
    public Integer solution(int[] a){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else{
                map.put(a[i],1);
            }
            if(map.get(a[i])%2==0){
                map.remove(a[i]);
            }
        }
        for(Map.Entry<Integer,Integer> temp:map.entrySet()){
            return temp.getKey();
        }
        return null;
    }
}
