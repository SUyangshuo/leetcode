package exam.NiuKe.PinDuoDuo;

import java.util.*;

public class 首尾相连的一组字符串 {
    /**
     * 给定一个字符串数组（字符串长度和数组长度均大于1且小于1024），
     * 所有字符均为大写字母。请问，给定的字符串数组是否能通过更换数组中元素的顺序，从而首尾相连，形成一个环。
     */

    /**
     * 题解：需要使用递归，遍历全部的排列，交换条件是符合交换后首尾呼应
     */


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] words = in.nextLine().split(" ");
            if(null == words || words.length < 2) System.out.println("false");
            boolean[] isUsed = new boolean[words.length];
            boolean flag = backtrack(words, new ArrayList<String>(), isUsed);
            if(flag) System.out.println("true");
            else System.out.println("false");
        }
    }

    private static boolean backtrack(String[] words, ArrayList<String> curList, boolean[] isUsed) {
        boolean flag = false;
        if(words.length == curList.size()) {
            String first = curList.get(0);
            String last = curList.get(curList.size()-1);
            return last.charAt(last.length()-1) == first.charAt(0);
        }
        for(int i = 0; i < words.length; ++i) {
            if(isUsed[i]) continue;
            if(curList.size() == 0) {
                curList.add(words[i]);
            } else {
                String prev = curList.get(curList.size()-1);
                if(prev.charAt(prev.length()-1) != words[i].charAt(0)) continue;
                curList.add(words[i]);
            }
            isUsed[i] = true;
            flag = backtrack(words, curList, isUsed);
            isUsed[i] = false;
            curList.remove(curList.size()-1);
            if(flag) break;
        }
        return flag;
    }
}
