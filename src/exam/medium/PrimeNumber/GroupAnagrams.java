package exam.medium.PrimeNumber;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    /**
     * 49： Group Anagrams
     * 两种方案，
     * 方案一：使用质数的性质，每两个质数的乘积无法分解为其他两位质数的乘积，分配26个质数，把每个字符串都表示为质数相乘
     * 方案二：把每个字符串按照字母顺序进行排序，排序后放到一个map中
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        int[] table=new int[]{2,3,5,7,11, 13,17,19,23,29, 31,37,41,43,47, 53,59,61,67,71, 73,79,83,89,97, 101};
        Map<Long,List<String>> map=new HashMap<>();
        for(String temp:strs){
            char[] tempChar=temp.toCharArray();
            long resultChar=1;
            for(char c:tempChar){
                resultChar=resultChar*table[c-97];
            }
            if(map.containsKey(resultChar)){
                map.get(resultChar).add(temp);
            }else {
                List<String> resutList=new ArrayList<>();
                resutList.add(temp);
                map.put(resultChar,resutList);
            }
        }
        for(Map.Entry<Long,List<String>> maplist:map.entrySet()){
            result.add(maplist.getValue());
        }
        return result;
    }
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        for(String temp:strs){
            char[] tempChar=temp.toCharArray();
            //按照字母大小排序
            String resultChar=rank(tempChar);

            if(map.containsKey(resultChar)){
                map.get(resultChar).add(temp);
            }else {
                List<String> resutList=new ArrayList<>();
                resutList.add(temp);
                map.put(resultChar,resutList);
            }
        }
        result.addAll(map.values());

        return    result     ;

    }
    public static String rank(char[] a){
       List<Character> list = new ArrayList<>();
       for(char c:a){
           list.add(c);
       }
       Collections.sort(list);
       String result="";
       for(Character c:list){
           result  += c;
       }
        return result;
    }

    public static void main(String[] args) {
        String[] a=new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams2(a);
    }
}
