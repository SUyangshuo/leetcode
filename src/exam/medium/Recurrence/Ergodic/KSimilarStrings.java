package exam.medium.Recurrence.Ergodic;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class KSimilarStrings {
    /**
     * 854. K-Similar Strings
     * 当字符串A通过交换自身的字符位置K次能得到字符串B的话，就说字符串A和B的相似度为K,求k值
     *
     * 重点：同时遍历a串和b串，遇到 相同的位置就++，如果遇到a[i]==b[i],while循环继续 遍历直到a[j]==b[i]进行交换，count++
     *      注意要广度优先遍历，所有可以更换的位置都进行更换
     */
    public String swap(String s, int i, int j){
        char[] cs=s.toCharArray();
        char tmp=cs[i];
        cs[i]=cs[j];
        cs[j]=tmp;
        return new String(cs);
    }

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        int res = 0;
        Set<String> used = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.add(A);
        int start = 0;
        //找到第一个不同的元素起始位置
        while (A.charAt(start) == B.charAt(start)) start++;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String s = queue.removeLast();
                int j = start;
                while (s.charAt(j) == B.charAt(j)) j++;
                //广度优先遍历，每一个可以替换的位置都进行交换，
                for (int k = j+1; k < B.length(); k++) {
                    if (s.charAt(k) == B.charAt(j)) {
                        String ss = swap(s, j, k);
                        if (used.contains(ss)) continue;
                        if (ss.equals(B)) return res+1;
                        queue.addFirst(ss);
                        used.add(ss);
                    }
                }
            }
            res++;
            start++;
        }

        return res;
    }

    public static int kSimilarity2(String A, String B) {
        int count=0;
        char[] Achar=A.toCharArray();
        for(int i=0;i<Achar.length;i++){
            if(Achar[i]==B.charAt(i)){
                continue;
            }
            count++;
            int j=i+1;
            while(j<Achar.length){
                if(Achar[j]==B.charAt(i)){
                    //这时 A[I]和a[j]交换
                    Achar[j]= Achar[i];
                    break;
                }
                j++;
            }
        }
        return count;
    }


}
