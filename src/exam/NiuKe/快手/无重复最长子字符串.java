package exam.NiuKe.快手;

import java.util.HashMap;
import java.util.Scanner;

public class 无重复最长子字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a=in.nextLine();
        System.out.print(lengthOfLongestSubstring(a));
    }
    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        //map中key存放字符，value存放字符位置
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();

        int left=0,right=0;
        int max=0;
        for(int i=0;i<s.length();i++){

            if(!hashMap.containsKey(chars[i]) || hashMap.get(chars[i])<left){
                hashMap.put(chars[i],i);
                right++;
                max=max>(right-left)?max:(right-left);

            }else{

                left=hashMap.get(chars[i])+1;
                hashMap.put(chars[i],i);
                right++;

                max=max>(right-left)?max:(right-left);

            }

        }
        return max;
    }
}
