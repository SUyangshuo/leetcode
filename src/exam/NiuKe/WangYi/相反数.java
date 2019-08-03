package exam.NiuKe.WangYi;

import java.util.Scanner;

public class 相反数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();

        StringBuilder string=new StringBuilder(n);

        int temp=Integer.valueOf(string.reverse().toString());
        System.out.println(temp+Integer.valueOf(n));

    }

}
