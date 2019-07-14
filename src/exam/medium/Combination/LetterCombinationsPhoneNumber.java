package exam.medium.Combination;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 17: Letter Combinations of a Phone Number
 * 给定一些数字串，给出每个数字代表的字符的组合，单个数字内的字母不组合
 */


public class LetterCombinationsPhoneNumber {
    /**
     * 方法一：三重for循环，遍历给定的数字串，把数字对应的字母添加到队列中，
     然后对于第二个数字串，依次删除队首元素，向队列中添加队首元素和新添加的字母的组合
     */

    public static  List<String> letterCombinations(String digits) {
        char[] temp=digits.toCharArray();
        Queue<String> queue = new LinkedList<String>();
        List<String> result=new LinkedList<String>();

        String[] string=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(char c:temp){

            int cc=Integer.parseInt(String.valueOf(c));
            char[] forTemp=string[cc].toCharArray();//a b c
                if(queue.peek() != null){
                    int length = queue.size();
                    for(int i=0;i<length;i++){
                        String a=queue.poll();
                        for(char d:forTemp){
                            queue.offer(a+String.valueOf(d));
                        }
                    }

                }else{
                    for(char d:forTemp){
                        queue.offer(String.valueOf(d));
                    }
                }

        }
        result.addAll(queue);

        return result;
    }

    public static void main(String[] args) {
       List<String> list=letterCombinations("23");

       for(String sss:list){
           System.out.println(sss);
       }

    }

}
