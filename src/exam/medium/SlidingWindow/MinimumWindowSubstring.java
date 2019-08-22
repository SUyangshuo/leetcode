package exam.medium.SlidingWindow;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.time.temporal.Temporal;
import java.util.*;

public class MinimumWindowSubstring {
    /**
     * 76. Minimum Window Substring
     *
     * 给定一个S,T，求s中包含t全部元素的最小子串
     *
     * 滑动窗口判断   难度非常高，思想容易理解，但是实现困难，
     */
    public static String minWindow(String s, String t) {
        if(t==null || t.length()==0 || s.length()<t.length()){
            return null;
        }
        if(s.equals(t)){
            return s;
        }

        Map<Character,Integer> Tmap=new HashMap<>();

        for(char temp:t.toCharArray()){
            if(Tmap.containsKey(temp)){
                Tmap.put(temp,Tmap.get(temp)+1);
            }else {
                Tmap.put(temp,1);
            }
        }
        int i=0;//左指针
        int j=0;//右指针
        //滑动窗口运动
        int count=0;
        int minlength=Integer.MAX_VALUE;
        int minStart=0;
        while(j<s.length()){

            if(Tmap.containsKey(s.toCharArray()[j]) ) {
                Tmap.put(s.toCharArray()[j], Tmap.get(s.toCharArray()[j]) - 1);
                if (Tmap.get(s.toCharArray()[j]) >= 0) {
                    count++;
                }
                //说明找到了包含t的子串 开始收缩左边界
                while (count == t.length()) {
                    if (j - i+1 < minlength) {
                        minlength = j - i+1;
                        minStart = i;
                    }
                    if (Tmap.containsKey(s.toCharArray()[i])) {
                        Tmap.put(s.toCharArray()[i], Tmap.get(s.toCharArray()[i]) + 1);
                        if (Tmap.get(s.charAt(i)) > 0) {
                            // 如果加1之后小于1，说明之前是负数，说明现在窗口内还有多个T中的字符，需要继续向前移动窗口
                            // 如果大于1才停止向前移动窗口
                            count--;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        if((minlength==Integer.MAX_VALUE  && count==0) ||  minlength==Integer.MAX_VALUE){
            return null;
        }
        return  s.substring(minStart, minlength + minStart);


    }
    //优化
    public String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] t_count = new int[256];
        for (char c : t.toCharArray())
        {
            t_count[c]++;
        }

        // find the 1st shortest windown
        int[] s_count = new int[256];
        int head = 0;
        while (head < s.length())
        {
            s_count[s.charAt(head)]++;
            if (head >= t.length() - 1 && cover(s_count, t_count)) {
                break;
            }
            ++head;
        }

        if (head == s.length()) return "";
        int tail = 0;
        while (cover(s_count, t_count))
        {
            s_count[s.charAt(tail++)]--;
        }
        s_count[s.charAt(--tail)]++;

        // sliding window to find the min
        int min_len = head - tail + 1;
        int min_h = head;
        int min_t = tail;
        ++head;
        while (head < s.length())
        {
            // head always moves forward
            s_count[s.charAt(head++)]++;

            // try to move tail
            while (cover(s_count, t_count))
            {
                s_count[s.charAt(tail++)]--;
            }
            s_count[s.charAt(--tail)]++;

            int len = head - tail;
            if (len < min_len)
            {
                min_len = len;
                min_h = head - 1;
                min_t = tail;
            }
        }

        return s.substring(min_t, min_h + 1);
    }

    boolean cover(int[] s, int[] target)
    {
        for (int i = 0; i < s.length; ++i)
        {
            if (s[i] < target[i])
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        minWindow("babb","baba");
    }
}
