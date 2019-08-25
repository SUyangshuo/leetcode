package exam.medium.Recurrence.dp;

public class 删除最少元素成为回文串 {
    /**
     * 一个字符串删除最少的元素，使他成为回文串
     *
     * 使用二维dp
     * 如果word【i】==word【j】
     */
    public static int reverse(String s){
        if(s==null || s.length()<2)
            return 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        int[][] res = new int[3][len];
        for(int i=2;i<len;++i){
            int t = i%3;
            for(int j=0;j<len-i;++j){
                if(ch[j]==ch[j+i])
                    res[t][j+i]=res[f(t-2)][j+i-1];
                else
                    res[t][j+i]=Math.min(res[f(t-1)][j+i-1], res[f(t-1)][j+i])+1;
            }
        }
        return res[(len-1)%3][len-1];
    }
    public static int f(int n){
        return n<0?n+3:n;
    }
}
