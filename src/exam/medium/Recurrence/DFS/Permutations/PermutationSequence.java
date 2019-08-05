package exam.medium.Recurrence.DFS.Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    /**
     * 60. Permutation Sequence
     *
     * 给n个数，求第k个排列
     * 数据的顺序排列存在一定规律n个数的排列为n！  则最高位确定后剩下的排列数位（n-1）！
     * 根据这个规律  k/(n-1)!可以求出最高位 位置，然后对（n-1）！取余可以更新k值
     *
     * 注意：通过相似的规律可以反推出，通过给定的排列，求出是第几个排列
     */
    public String getPermutation(int n, int k) {

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }

        //求n-1！
        k=k-1;//符合排列顺序
        int  factorial=1;
        StringBuilder string=new StringBuilder();
        for(int i=1;i<n;i++){
            factorial=factorial*i;
        }
        int t=n-1;
        while(t>=0){
            int temp=k/factorial;
            string.append(list.get(temp));
            list.remove(temp);
            k=k%factorial;
            if(t!=0){//不是最后一位
                factorial=factorial/t;
            }
            t--;
        }
        return string.toString();
    }

}
