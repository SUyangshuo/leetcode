package exam.NiuKe.腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 复读 {
    public  static Scanner in = new Scanner(System.in);
    public  static Scanner in2 = new Scanner(System.in);

    public static void main(String[] args) {
        int n=in.nextInt();//长度限制
        String string="";
        List<String> list=new ArrayList<>();
        while(n>=0){
            String temp=in.hasNextLine()?in.nextLine():null;

            string=string+temp;
            n--;
        }
        int m=in.hasNext()?in.nextInt():1;
        List<String> result=new ArrayList<>();

        while(m>0){
            String temp=in2.hasNextLine()?in2.nextLine():null;
            list.add(temp);
            m--;
        }
        for(String temp:list){
            if(solution(temp,string)){
                result.add(temp);
            }
        }
        System.out.println(result.size());

    }
    public static boolean solution(String a,String b){
        //判断a是否是发送串的子串
        int Blength=b.length();
        int Alength=a.length();
        int t=Blength%Alength;
        if(a.charAt(Alength-1-t)!=b.charAt(Blength-1)){
            return false;
        }
        b=b.replaceAll(a,"");
        if(b.equals("")){
            return true;
        }
        //遍历这时的b和a
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)!=a.charAt(i)){
                return false;
            }
        }
        return true;
    }

}
