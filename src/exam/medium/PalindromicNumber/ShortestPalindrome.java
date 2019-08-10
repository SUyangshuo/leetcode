package exam.medium.PalindromicNumber;

/**
 * @author YangShuo
 * @create 2019/2/17
 * @comment
 */

/**
 * 214. Shortest Palindrome   添加最少的字符使得字符串变成一个回文串
 */
public class ShortestPalindrome {

        public String shortestPalindrome(String s) {
            int i = 0, n = s.length();
            for (int j = n - 1; j >= 0; --j) {
                if (s.charAt(i) == s.charAt(j)) ++i;
            }
            if (i == n) return s;
            String rem = s.substring(i);
            String rem_rev = new StringBuilder(rem).reverse().toString();
            return rem_rev + shortestPalindrome(s.substring(0, i)) + rem;
        }

}
