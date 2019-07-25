package exam.medium.Sort.ListSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Soultion solution=new Soultion();
        int[][] a =new int[][]{{1,4},{0,0}};

        solution.merge(a);
    }

}

/**
 * 56. Merge Intervals
 * 合并重叠区间
 * 给定的数组【【1,4】，【2,8】，【9,11】】
 * 合并有重叠的区间
 * 【【1,8】【9,11】】
 */
class Soultion{
    public int[][] merge(int[][] intervals) {
        //遇到维度不高的数组的问题，首先考虑排序对结果是否有帮助
        //对子数组按照第一个数字排序后，可以减少计算量
        List<int[]> list=new ArrayList<>();
        for(int[] temp:intervals){
            list.add(temp);
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //获得排序后的list
        List<int[]> resultTemp=new ArrayList<>();
        int i=0;
        for(int[] temp:list){
            if(resultTemp.size()==0){
                resultTemp.add(temp);

            }else{
                int[] last=resultTemp.get(i);
                if(temp[0]<=last[1]){
                    resultTemp.get(i)[1]=Math.max(resultTemp.get(i)[1],temp[1]);
                    resultTemp.get(i)[0]=Math.min(resultTemp.get(i)[0],temp[0]);

                }else {
                    resultTemp.add(temp);
                    i++;
                }
            }
        }
        //结果转换
        int[][] result=new int[resultTemp.size()][2];
        int j=0;
        for(int[] temp:resultTemp){
            result[j]=temp;
            j++;
        }
        return result;
    }
}
