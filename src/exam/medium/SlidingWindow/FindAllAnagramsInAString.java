package exam.medium.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    /**
     * 438.Find All Anagrams in a String
     * 两个字符串s和p，让我们在s中找字符串p的所有变位次的位置，
     *所谓变位次就是字符种类个数均相同但是顺序可以不同的两个词
     *
     * 方法一：使用两个hash 在s上保持一个p长度的窗口，然后映射为map。比较p对应的hash时候匹配
     * 方法二：使用一个hash，加上指针窗口，移动的时候判断，需要一个额外的数字空间保存两个匹配串的差异程度
     */

    //方法一：
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        Map<Character,Integer> mapP=new HashMap<>();
        for(Character c:p.toCharArray()){
            if(mapP.containsKey(c)){
                mapP.put(c,mapP.get(c)+1);
            }else {
                mapP.put(c,1);
            }
        }
        char[] newS=s.toCharArray();
        int count=p.length();
        int l=0,i=0;
        for(;i<s.length();i++){
            if(count>0 && mapP.containsKey(newS[i]) && mapP.get(newS[i])>=0){
                if(mapP.get(newS[i])>0){//todo：这种方法是防止出现同一个匹配串中出现重复的字符
                    count--;//只有新 位置出现匹配度情况下才--
                }

                mapP.put(newS[i],mapP.get(newS[i])-1);
                if(count==0 && i-l+1==p.length()){
                    result.add(l);
                }
            }
            if(i==p.length()-1 || i-l+1==p.length()){
                if(mapP.containsKey(newS[l]) ){
                    if(mapP.get(newS[l])>=0){
                        count++;
                    }
                    mapP.put(newS[l],mapP.get(newS[l])+1);

                }
                l++;
            }
        }
        return result;
    }
    //方法一优化
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int NumberOfDeference = p.length();  //差异度指数
        int left=0,right=0;  //窗口左右指针
        int[] asciiChars = new int[256];//记录p中字符有哪些及其数量的数组
        for (int i = p.length() - 1; i>=0; --i){
            ++asciiChars[p.charAt(i)];
        }

        for(;right<s.length();right++){ //滑动右窗口
            asciiChars[s.charAt(right)]--;  //在该字符相应位置减一
            //如果加进来的那个在p中，NumberOfDeference减一
            if(asciiChars[s.charAt(right)]>=0) NumberOfDeference--;
            if(right-left == (p.length()-1)){
                //如果这时窗口大小为p.length()
                if(NumberOfDeference==0) result.add(left);//这时出现一次匹配，将左窗口加到result中
                //下面是滑动左窗口的操作
                if(asciiChars[s.charAt(left)]>=0) {
                    NumberOfDeference++;
                //如果被踢出的那个在p中，NumberOfDeference加一
                }
                asciiChars[s.charAt(left)]++;
                //数组中相应字符计数位置加回来
                left++; //左窗口向右滑动
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findAnagrams("abab","ab");
    }
}
