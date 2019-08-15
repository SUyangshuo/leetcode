package exam.medium.Recurrence.dp;

public class RegularExpressionMatching {
    /**
     * 10. Regular Expression Matching  hard
     *
     * 字符串匹配，分别有两个字符串，t和p，p是.和*的正则匹配法，。表示任意一个字母 * 表示前一个字母是0个或者多个
     * 重点：方法一：递归匹配
     */
    //方法一：递归 速度较慢
    //假如匹配串中只包含.没有*，递归判断，第一个是匹配的话，判断之后是否匹配，递归的跳出条件是p为空的时候 ，t是否为空
    public boolean isMatch(String text, String pattern) {
        if(pattern.isEmpty()){
            return text.isEmpty();
        }
        //首字母判断
        boolean first=!text.isEmpty() && (text.charAt(0)==pattern.charAt(0) || pattern.charAt(0)=='.');
        return first && isMatch(text.substring(1),pattern.substring(1));
    }
    //当假如了* 时，p串只有在长度大于等于2的时候才有*
    public boolean isMatch2(String text, String pattern) {
        if(pattern.isEmpty())
            return text.isEmpty();

        //首字母判断
        boolean first=!text.isEmpty() && (text.charAt(0)==pattern.charAt(0) || pattern.charAt(0)=='.');
        //对于* 有两种情况，两个串首字母不匹配，但是p串第二位是* 这个时候匹配t的下一个和p 的下下一个   如果p的下一位是。的情况下和之前的一样
        //第二种情况，两个串首字母匹配，如果p的第二位是*的话，t移动一位，p不动，如果首字母，如果p的下一位是。的情况下，
        if(pattern.length()>=2 && pattern.charAt(1)=='*'){

            return  first && isMatch(text.substring(1),pattern) || (isMatch(text,pattern.substring(2)));

        }else{
            return first && isMatch2(text.substring(1),pattern.substring(1)); //todo:最外层没有return的时候  注意if条件的return要写全
        }
    }
    //方法二：dp
    public boolean isMatch3(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1]; // size大小
        dp[0][0] = true;
        for(int j = 1; j<=pattern.length(); j++){
            if(pattern.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2] ;
            }
        }

        for(int i = 1; i<=text.length(); i++){
            for(int j = 1; j<=pattern.length(); j++){
                if( pattern.charAt(j-1) == text.charAt(i-1) ||  pattern.charAt(j-1) == '.' ) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    if( pattern.charAt(j-1) == '*') {
                        dp[i][j] = dp[i][j-2] ;
                        if (text.charAt(i-1)  == pattern.charAt(j-2) || pattern.charAt(j-2)  == '.'){
                            dp[i][j] =  dp[i][j] || dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[text.length()][pattern.length()];//坐标
    }


    }
