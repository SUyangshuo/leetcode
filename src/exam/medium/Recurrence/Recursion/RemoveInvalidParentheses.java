package exam.medium.Recurrence.Recursion;

import java.util.*;

public class RemoveInvalidParentheses {
    /**
     * 301. Remove Invalid Parentheses
     * 删除括号表达式中的多余部分，使之成为合法的括号表达式，注意表达式中可能存在字母
     *
     * 重点：使用递归，一般情况下，见到括号，使用栈进行括号匹配，左括号压栈，右括号弹栈，可以使用一个count来模拟栈，
     *      左括号++，右括号--。当遇到有括号，但是count--后小于0，遇到这种情况的时候，需要对i之前的部分进行判断，删除哪一个）
     *      理论上，删除哪一个都可以，，然后剩下的部分进行递归
     */
    public static void main(String[] args) {
        removeInvalidParentheses("()())()");
    }
    //
    public List<String> removeInvalidParentheses2(String s) {
        List<String> result = new ArrayList<String>();
        removeInvalidParentheses(s, result, 0, 0, new char[]{'(', ')'});
        return result;
    }
    public void removeInvalidParentheses(String s, List<String> result, int lastRemoveIndex, int lastCheckedIndex, char[] pattern){
        for(int stack = 0, i = lastCheckedIndex ; i<s.length() ; i++){ //stack是每一段的括号匹配的标记
            int cur = s.charAt(i);
            if(cur == pattern[0]) stack++;
            if(cur == pattern[1]) stack--;
            if(stack>=0) continue;
            for(int j = lastRemoveIndex ; j <= i ; j++){
                if(s.charAt(j)==pattern[1] && (j == lastRemoveIndex || s.charAt(j-1)!=pattern[1])){
                    removeInvalidParentheses(s.substring(0, j) + s.substring(j+1), result, j, i, pattern);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(pattern[0] == '('){
            removeInvalidParentheses(reversed, result, 0, 0, new char[]{')', '('});
        }else{
            result.add(reversed);
        }
    }


    //失败，只能解决右括号
    public static List<String> removeInvalidParentheses(String s){
        List<Set<String>> result=new ArrayList<>();
        ergodic(s,0,result);
        //解析result
        List<String> list=new ArrayList<>();

        for(Set<String> set:result){
            if(list.isEmpty()){
                list.addAll(set);
                continue;
            }
            for(String setTemp:set){
                int listLength=list.size();
                for(int i=0;i<listLength;i++){

                    list.set(i,list.get(i)+setTemp);
                }
            }
        }
        return list;

    }
    public static void ergodic(String s,int left, List<Set<String>> result) {
        int count=0;
        char[] toChar=s.toCharArray();
        List<Integer> rightIndex=new ArrayList<>();
        List<Integer> leftIndex=new ArrayList<>();
        //最后一个）标记
        int lastRight=0;
        for(int i=left;i<s.length();i++){
            if(toChar[i]=='('){
                count++;
                leftIndex.add(i);
            }else if (toChar[i]==')'){
                lastRight=i;
                count--;
                rightIndex.add(i);
            }
            if(count<0){//出现多余 ）
                verify(s.substring(left,i+1),result,rightIndex);
                ergodic(s.substring(i+1,s.length()),i+1,result);
                return;
            }

        }
        if(count>0){
            //

        }
        if(count==0){
            Set<String> tempset=new HashSet<>();
            tempset.add(s);
            result.add(tempset);
        }
    }
    public static void verify(String s, List<Set<String>> list, List<Integer> RightIndex) {
        //list中保存全部 组合可能性
        Set<String> set=new HashSet<>();
        for(Integer temp:RightIndex){
            StringBuilder tempString=new StringBuilder(s);
            set.add(tempString.replace(temp,temp+1,"").toString());
        }
        list.add(set);
    }
}
