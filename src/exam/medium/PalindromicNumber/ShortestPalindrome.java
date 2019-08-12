package exam.medium.PalindromicNumber;

/**
 * @author YangShuo
 * @create 2019/2/17
 * @comment
 */

/**
 * 214. Shortest Palindrome
 * 在字符串前添加最少的字符使得字符串变成一个回文串  找到最长的前缀回文串
 *
 * 方法一：双指针+递归，每次递归 都缩小了前缀回文串 长度
 * 方法二：使用kmp中next数组的产生原理，将s反转后  形成s+#+s' 的形式，找出该串的next数组
 */
public class ShortestPalindrome {
    // 方法一：使用双指针和递归
    public static String shortestPalindrome(String s) {
        int i = 0, n = s.length();
        for (int j = n - 1; j >= 0; --j) {
            if (s.charAt(i) == s.charAt(j)) ++i;
        }
        if (i == n) return s;
        String rem = s.substring(i);
        String rem_rev = new StringBuilder(rem).reverse().toString();
        return rem_rev + shortestPalindrome(s.substring(0, i)) + rem;
    }
    //方法二：使用kmp

    public static String shortestPalindrome3(String s) {
        String tmp=s+"#"+new StringBuilder(s).reverse().toString();
        int[] table=getTable(tmp);
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString()+s;

    }
    //KMP算法
    public static int[] getTable(String s){
        int len=s.length();
        int[] table=new int[len];
        char[] a=s.toCharArray();
        //i是从1开始
        for(int i=1,k=0;i<len;i++)
        {
            while(k>0&&a[i]!=a[k])
            {
                k=table[k-1];
            }
            if(a[i]==a[k])
                k++;
            table[i]=k;  //和下边的传统kmp产生数组不一样  没有向右移动
        }
        return table;
    }
    //传统kmp中next产生
    public static String shortestPalindrome2(String s) {
        String str=new StringBuffer(s).reverse().toString();
        char[] s2=new StringBuffer(s+"#"+str).toString().toCharArray();
        //构件next数组
        int[] next=new int[s2.length];
        next[0]=-1;
        int k=-1;
        int i=0;
        while(i<s2.length-1){
            if(k==-1 || s2[i]==s2[k]){//k=-1时 next[k ]没有意义
                k++;
                i++;
                next[i] = (s2[i] != s2[k]) ? k : next[k];
            }else {
                k=next[k];
            }
        }
        int max=next[s2.length-1]+1;
        return new StringBuilder(s.substring(max)).reverse().toString()+s;
    }

    public static void main(String[] args) {
        shortestPalindrome3("abab");
    }

}
