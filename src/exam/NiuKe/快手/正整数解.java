package exam.NiuKe.快手;
import java.util.Scanner;



public class 正整数解 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        String[] s = ss.split("=");//将等式两边的分开处理
        int a=0; //代表累积常数
        int b=0; //代表累积系数
        //等式左边
        a += f(s[0])[0];
        b += f(s[0])[1];
        //等式右边
        a -= f(s[1])[0];
        b -= f(s[1])[1];

        if(a==0)
            System.out.println("-1");
        else if(b==0){
            System.out.println("-1");
        }else{
            System.out.println(-a/b); //注意打印时候的符号
        }
    }

    public static int[] f(String s){
        int[] t= new int[2]; //t[0]存常数，t[1]存x前面的系数
        int e=0,f=0; //f取符号，e取当前读到的数字
        if(s.substring(0, 1).equals("-")) //先判断第一位是整数还是负数
            f=-1;
        else
            f=1;
        int bb=0; //bb用于存放一个数
        for(int i=0;i<s.length();i++){

            String c=s.substring(i, i+1); //c取当前字符（注意是字符串的形式
            if(c.equals("+") ){
                t[0] += f*bb; //读到“+”时，说明当前读到的是一个常数，存入常数数组
                f=1; //读取到“+”时，将符号置为1，代表加一个正数
                bb=0; //存完一个数之后，记得将该变量置为0，以便存储后续的数
            }else if(c.equals("-") ){
                t[0] +=f*bb;
                f=-1; //读取到“+”时，将符号置为-1，代表加一个负数
                bb=0;
            }else if(c.equals("*")){
                if(bb==0)
                    bb=1;
                t[1] += f*bb;bb=0;
            }else{
                e = Integer.valueOf(c);
                bb = bb*10+e*f;
                f=1;
                if(i==s.length()-1) //当读取到最后一位不是x且还未结束时，说明当前是一个常数，累积加到常数中
                    t[0] += f*bb;
            }
        }
        return t;
    }
}

