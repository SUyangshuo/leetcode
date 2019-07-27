package exam.medium.Recurrence.dp;

import java.util.List;

public class WordBreak {
}

/**
 * 139. Word Break
 *
 * dp灵活应用
 * 使用一维的dp保存之前的信息
 * 遍历字符的每一个以字母结束的字符串，判断截取字符串之前的字符串是否是可用的
 */
class Solution_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()<=0){
            return false;
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
