package exam.NiuKe.远景;

import java.util.Scanner;
import java.util.Stack;

public class 第一题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n=in.nextLine();
        int length=n.split(",").length;
        int[] a=new int[length];
        for(int i=0;i<length;i++){
            a[i]=Integer.valueOf(n.split(",")[i]);
        }
        if(a.length==1){
            System.out.println(0);
            return;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(a[0]);
        int temp=-1;
        int max=0;
        for(int i=1;i<length;i++){
            if(temp!=-1){
                if(a[i]<=temp){
                    temp=a[i];
                }else {
                    max+=stack.peek()-temp;
                    temp=-1;
                    stack.push(a[i]);
                }
                continue;
            }
            if(a[i]>stack.peek()){
                stack.push(a[i]);
            }else {
                temp=a[i];
            }

        }
        if(temp!=-1){
            max+=stack.peek()-temp;
        }
        System.out.println(max);

    }
}
