package exam.medium.Recurrence.Ergodic;

import java.util.*;

/**
 * @author YangShuo
 * @create 2019/1/22
 * @comment
 */

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 */
public class WordLadderI {

    public static void main(String[] args) {

        String[] a={"hot","dot","dog","lot","log","cog"};

        List<String> list=new ArrayList<>();

        list= Arrays.asList(a);


        int i = ladderLength("hit","cog",list);

        System.out.print("结果是" + i);
    }
    //利用bfs广度优先遍历
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordListSet = new HashSet(wordList);

        if(!wordListSet.contains(endWord)){
            return 0;
        }
        //创建队列
        //LinkedList<String> quen=new LinkedList<>();
        Set<String>  quen = new HashSet();
        int allword=1;
        quen.add(beginWord);

        while(!quen.contains(endWord)){

            Set<String>  tempset = new HashSet();
            for(String temp:quen){
                for(int i=0;i<temp.length();i++){
                    char index='a';
                    char ss[] = temp.toCharArray();
                    while(index-96<27){
                        //System.out.println("index---"+index);
                        ss[i] = index;
                        index++;
                        String t = String.valueOf(ss);
                         System.out.println("转换后"+t);
                        if(t.equals(endWord)){
                            return allword+1;
                        }
                        if(wordListSet.contains(t)){
                            System.out.println("转换后22222"+t);
                            tempset.add(t);
                            wordListSet.remove(t);
                        }
                    }
                }
            }
            allword++;
            if (tempset.size() == 0) { // it nevert get to the endWord
                return 0;
            }
            quen=tempset;

        }
        return allword;
    }
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
            List<String> reached = new ArrayList<>();
            reached.add(beginWord);
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;
            wordSet.add(endWord);

            int distance = 1;
            while (!reached.contains(endWord)) { //到达该目的地
                List<String> toAdd = new ArrayList<>();
                for (String each : reached) {
                    for (int i = 0; i < each.length(); i++) {
                        char[] chars = each.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            chars[i] = c;
                            String wd = new String(chars);
                            if (wordSet.contains(wd)) {
                                toAdd.add(wd);
                                wordSet.remove(wd); //记录访问状态
                            }
                        }
                    }
                }
                distance++;
                if (toAdd.size() == 0) return 0; //没有编辑距离为1的单词
                reached = toAdd;
            }
            return distance;
    }

        public int ladderLength3(String beginWord, String endWord, List<String> wordList) {

            Set<String> wordSet = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            int dist = 1;

            while (!visited.contains(endWord)) {
                Set<String> temp = new HashSet<>();
                for (String word: visited) {
                    for (int i = 0; i < word.length(); i++) {
                        char[] chars = word.toCharArray();
                        for (int j = (int)'a'; j < (int)'z' + 1; j++) {
                            chars[i] = (char)j;
                            String newWord = new String(chars);
                            if (wordSet.contains(newWord)) {
                                temp.add(newWord);
                                wordSet.remove(newWord);
                            }
                        }
                    }
                }
                dist += 1;
                if (temp.size() == 0) { // it nevert get to the endWord
                    return 0;
                }

                visited = temp;
            }

            return dist;
        }



}
