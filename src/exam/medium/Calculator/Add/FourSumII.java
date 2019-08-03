package exam.medium.Calculator.Add;

import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    /**
     * 454. 4Sum II
     * 给四个list，每个list选一个数字，求四个数字和为0的组合有多少种，
     * 最暴力的方法是4重循环，然后可以优化最后一层循环为map，
     * 再优化为把前两个循环的结果存放在map中，和后两个循环比较
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();//key为两个数和，value是次数

        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int temp=A[i]+B[j];
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,1);
                }
            }
        }
        int count=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int temp=C[i]+D[j];
                if(map.containsKey(-temp)){
                    count+=map.get(-temp);
                }
            }
        }
        return count;

    }
}
