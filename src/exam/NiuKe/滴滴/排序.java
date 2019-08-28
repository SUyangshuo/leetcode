package exam.NiuKe.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 排序 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Scanner in2=new Scanner(System.in);
        int n=in.nextInt();

        String[] charIn=new String[n+n-1];
        for(int i=0;i<(n+n-1);i++){
            charIn[i]=in2.nextLine();
        }
//        int count=jisuan(charIn);
//        System.out.println(count);

    }
    public static Integer jisuan(String tt){
        String[] charIn=tt.split(" ");
        Stack<Integer> stackNumber=new Stack<>();
        Stack<String> stackIndex=new Stack<>();
        for(int i=0;i<charIn.length;i++){
            String temp=charIn[i];
            if(!charIn[i].equals("+")  && !charIn[i].equals("-") && !charIn[i].equals("*") && !charIn[i].equals("/")){
                stackNumber.add(Integer.valueOf(charIn[i]));
            }

            if(temp.equals("+") || temp.equals("+")){
                stackIndex.add(temp);
            }
            if(temp.equals("*") || temp.equals("/")){
                if(temp.equals("*")){
                    stackNumber.add(stackNumber.pop()*Integer.valueOf(charIn[++i]));
                }
                if(temp.equals("/")){
                    stackNumber.add(stackNumber.pop()/Integer.valueOf(charIn[++i]));
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list.addAll(stackNumber);
        list2.addAll(stackIndex);
        int count=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list2.get(i-1).equals("+")){
                count+=list.get(i);
            }
            if(list2.get(i-1).equals("-")){
                count-=list.get(i);
            }
        }
        return count;

    }
}
