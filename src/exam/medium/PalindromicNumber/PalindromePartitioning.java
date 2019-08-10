package exam.medium.PalindromicNumber;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution_PalindromePartitioning solution=new Solution_PalindromePartitioning();
        solution.partition("aab");
    }

}

/**
 * 131. Palindrome Partitioning
 * 给定字符，判断全部的子数组分割
 *先使用dp求出字符串中全部的回文串，
 * 然后递归调用解析dp，两点之间是回文串的就输出，剩下的部分递归调用
 */
class Solution_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>>  result=new ArrayList<>();
        List<String> list=new ArrayList<>();
        boolean[][] dp=dp(s);
        analysis(result,list,dp,0,s);
        return result;
    }
    //解析dp，递归求出所有的回文子串
    public void  analysis(List<List<String>> result
                                        ,List<String> list
                                        ,boolean[][] dp,int start,String s){
            //开始元素大于最后一个的时候将推送list结果
            if(start>=s.length()){
                result.add(new ArrayList<>(list));
                return;
            }
            //注意这里遍历dp和创建dp的倒三角一致
            for(int i=start;i<s.length();i++){
                if(dp[i][start]){
                    String temp=s.substring(start,i+1);
                    list.add(temp);
                    analysis(result,list,dp,i+1,s);
                    list.remove(list.size()-1);
                }
            }
    }
    //求出字符串中两点是否是回文数
    public boolean[][] dp(String s){
       boolean[][] dp=new boolean[s.length()][s.length()];
       //判断i-j之间是否是回文串
       for(int i=0;i<s.length();i++){
           for(int j=0;j<=i;j++){
               if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[i-1][j+1])){
                    dp[i][j]=true;
               }
           }
       }
       return dp;
    }

}
