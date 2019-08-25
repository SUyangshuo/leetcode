package exam.medium.Recurrence.dp;

public class EditDistance {
    /**
     * 72. Edit Distance
     * 求两个字符串的编辑距离
     *
     * 经典dp问题，两个字符串之间的编辑距离，有三种变换方式，增加，删除，修改，
     * 使用dp保留局部信息，记录编辑次数，
     * word1【i】==word2【j】------dp[i][j]=dp[i-1][j-1]
     *
     *  word1【i】!=word2【j】 -----min(dp[i-1][j])+1,dp[i][j-1]+1,dp[i-1][j-1]+1)
     *  三个位置表示的含义为删除，增加，替换
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;

        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;


        //iterate though, and check last char
        for (int i = 1; i <= len1; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {
                char c2 = word2.charAt(j-1);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int replace = dp[i-1][j-1] + 1;
                    int insert = dp[i-1][j] + 1;
                    int delete = dp[i][j-1] + 1;

                    int min = Math.min(replace, insert);
                    min = Math.min(min,delete);
                    dp[i][j] = min;
                }
            }
        }

        return dp[len1][len2];
    }
}
