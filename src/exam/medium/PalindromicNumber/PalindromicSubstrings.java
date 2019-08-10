package exam.medium.PalindromicNumber;

public class PalindromicSubstrings {
    /**
     * 647. Palindromic Substrings
     *
     * 求出全部的回文串  允许重复
     */
    public int countSubstrings(String s) {
        char[] string=s.toCharArray();
        int[][] dp=new int[s.length()][s.length()];
        int result=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(i==j){
                    dp[j][i]=1;
                }else if(i-j==1 && string[i]==string[j]){
                    dp[j][i]=1;
                }else if(string[i]==string[j] && dp[j+1][i-1]==1){
                    dp[j][i]=1;
                }
                result+=dp[j][i];
            }
        }
        return result;
    }
    //方法二：双指针窗口
    public int countSubstrings2(String s) {
        int n = s.length();
        int ans = 0;
        if(n==0)
            return 0;

        for(int centre=0; centre<n; centre++)
        {
            ans++;
            int left = centre-1;
            int right = centre+1;

            while(left>=0 && right<n && s.charAt(left)== s.charAt(right))
            {
                ans++;
                left--;
                right++;
            }

            left = centre;
            right = centre+1;
            while(left>=0 && right<n && s.charAt(left)== s.charAt(right))
            {
                ans++;
                left--;
                right++;
            }

        }
        return ans;
    }
}
