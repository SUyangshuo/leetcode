package exam.medium.Recurrence.dp;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * 32. Longest Valid Parentheses
     * 求最长的有效括号串
     * 方法一：使用两个栈 一个保存字母 一个保存下标
     * 方法二：dp
     *
     */
    //     方法一：使用双栈，一个栈压字符，一个栈用来压下标，遇到）就判断弹栈
    public static int longestValidParentheses(String s) {
        if(s==null|| s.length()==0){
            return 0;
        }
        Stack<Character> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int max=0;
        int i=0;
        for(Character temp:s.toCharArray()){
            if(temp=='('){
               stack1.push('(');
               stack2.push(i);
            }else if(temp==')'){
                if(!stack1.isEmpty() && stack1.peek()=='('){
                    stack1.pop();
                    stack2.pop();
                    int index=stack2.isEmpty()?i+1:i-stack2.peek();
                    max=Math.max(index,max);
                }else {
                    stack1.push(')'); //每一个多出来没有匹配上的字符都是相当于新的开始起点
                    stack2.push(i);
                }

            }
            i++;
        }
        return max;
    }
    //dp  dp[i]表示以i结尾的最长括号子串长度
    public static int longestValidParentheses2(String s) {
        if(s==null|| s.length()==0){
            return 0;
        }
        int[] dp=new int[s.length()];
        char[] news=s.toCharArray();
        dp[0]=0;
        int max=0;
        for(int i=1;i<s.length();i++){//dp下标只在）更新
            if(news[i]=='('){
                if(news[i-1]==')'){//当括号是左括号的时候，需要判断前一个是否是 ） 是的话 继承（的最长子串
                    dp[i]=dp[i-1];
                }else{
                    dp[i]=0;  //如果前一个是（  说明是新的起点，产生了不匹配
                }
            }else {
                if(news[i-1]=='('){  //当前是）括号的时候，前一个是（说明增加了一个对匹配
                    dp[i]=dp[i-1]+2;
                }else{
                    if(i-1-dp[i-1]>=0 && news[i-1-dp[i-1]]=='('){  //如果前一个是）括号，需要找到）最长子串之前的是不是（
                        dp[i]=dp[i-1-dp[i-1]]+dp[i-1]+2;
                    }else{
                        dp[i]=0;

                    }
                }
            }
            max=Math.max(dp[i],max);

        }
        return max;

    }

    public static void main(String[] args) {
        longestValidParentheses2(")()())");
    }
}
