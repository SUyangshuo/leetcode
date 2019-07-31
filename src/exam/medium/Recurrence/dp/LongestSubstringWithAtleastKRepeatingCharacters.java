package exam.medium.Recurrence.dp;


public class LongestSubstringWithAtleastKRepeatingCharacters {
    /**
     *  395. Longest Substring with At least K Repeating Characters
     *  根据给定的字符串，求最长子串，满足串内每个字符个数至少为k
     *
     *  方法一：遍历出字符串中字符所有个数不到k的字符，以这些为分割点，然后遍历分割后的字符串 找到最长的
     *
     *  方法二：
     */
    public static void main(String[] args) {

    }
    public static int solution(String s, int k ,int max){
        if(s==null || s.length()<=0 || k<=0){
            return max;
        }
        int[] map=new int[26];
        //需要自己写分割的正则表达式

        for(int i=0;i<s.toCharArray().length;i++){
            map[s.toCharArray()[i]-'a']++;
        }

        StringBuilder regular=new StringBuilder("");
        boolean firstSplit=true;
        for(int i=0;i<26;i++){
            if(map[i]<k && map[i]!=0){
                if(firstSplit){
                    regular = regular.append((char)(i+'a'));
                    firstSplit=false;
                }else{
                    regular = regular.append('|').append((char)(i+'a'));
                }

            }
        }
        if(regular.toString().length()<1 && s.length()>max){
            return s.length();
        }
        String[] result=s.split(regular.toString());

        for(int i=0;i<result.length;i++){
            //使用递归
            max=solution(result[i],k,max);

        }
        return max;
    }

}
