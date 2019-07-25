package exam.medium.Recurrence.DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /**
     * 经典DFS题目，22-Generate Parentheses
     * 该题目是有界条件的DFS。一般称为回溯问题
     *
     * 进行括号匹配，给出所有的括号匹配的情况，使用深度递归遍历
     */
    public List<String> generateParenthesis(int n) {

        List<String> list=new ArrayList<>();
        dfs("",list,n,n);

        return list;
    }
    public List<String> dfs(String string,List<String> result,int left,int right){

        if(left==0&&right==0){
            result.add(string);
            return result;
        }
        if(left>right){
            return null;
        }
        if(left>0){
            dfs(string+"(",result,left-1,right);
        }
        if(right>0){
            dfs(string+")",result,left,right-1);
        }
        return result;

    }


}
