package exam.medium.Stack;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions {
    /**
     * 1003. Check If Word Is Valid After Substitutions
     * 描述：类似消消乐，遇到abc就消失，最后如果有没消掉的就是false
     *
     * 重点：使用栈
     */
    public static boolean isValid(String S) {
        Stack<Character> stack=new Stack<>();
        if(S.length()<3){
            return false;
        }
        int i=2;
        char[] newS=S.toCharArray();
        stack.add(newS[0]);
        stack.add(newS[1]);

        while(i<newS.length){
            if(stack.size()>1){
                String temp1 = String.valueOf(newS[i]);
                String temp2 = String.valueOf(stack.pop());
                String temp3 = String.valueOf(stack.pop());

                String temp=temp1+temp2+temp3;
                if(!temp.equals("cba")){
                    stack.push(temp3.charAt(0));
                    stack.push(temp2.charAt(0));
                    stack.push(newS[i]);
                }
                i++;

            }else {
                stack.push(newS[i]);
                i++;
            }
        }
        return stack.isEmpty();
    }
    //优化
    public boolean isValid2(String S) {// 每次把abc替换掉，只要看最终是不是空就行
        if (S.equals(""))
            return true;
        else {
            if (S.contains("abc")) {
                S = S.replace("abc", "");
                return isValid(S);
            } else
                return false;
        }
    }


    public static void main(String[] args) {
        isValid("aabcbc");
    }
}
