package exam.medium.Calculator.Mingle;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        Stack<String> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        char sArray[] = s.toCharArray();
        for(int i = 0 ; i < s.length(); i++){
            if(sArray[i] > '0' && sArray[i] <= '9'){  // if num = 10,111... while
                int j = i;
                int count = 0;
                while(sArray[j] >= '0' && sArray[j] <= '9'){ //考虑大于1位数的情况
                    count = count * 10 +  sArray[j] - '0';
                    j++;
                }
                i = j - 1;
                numStack.push(count);
            }
            else if(sArray[i] == '['){
                charStack.push(res);
                res = "";
            }
            else if(sArray[i] == ']'){
                StringBuilder temp = new StringBuilder(charStack.pop());
                int count = numStack.pop();
                while(count > 0){
                    temp.append(res);
                    count--;
                }
                res = temp.toString();
            }
            else
                res += sArray[i];
        }
        return res;
    }
}
