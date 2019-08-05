package exam.NiuKe.WangYi;

import java.util.Scanner;

public class 被3整除 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        for(int i=n;i<=m;i++){
            if(i%3%2==0){
                count++;
            }
        }
        System.out.println(count);
    }
}

