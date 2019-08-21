package exam.NiuKe.小红书;

import java.util.Scanner;
import java.util.Stack;

public class 翻转 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string=in.nextLine();
        String[] temp=string.split(" ");
        Stack<String> stack=new Stack<>();
        for(int i=temp.length-1;i>=0;i--){
            if(temp[i].trim().isEmpty()){
                continue;
            }
            if(i==0){
                System.out.print(temp[i]);
            }else {
                System.out.print(temp[i]+" ");

            }
        }

    }
}
