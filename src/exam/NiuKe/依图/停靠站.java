package exam.NiuKe.依图;

import java.util.Scanner;

public class 停靠站 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] in=new int[n];
        int[] out=new int[n];
        for(int i=0;i<n;i++){
            in[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            out[i]=scanner.nextInt();
        }

        int count=0;
        int renshu=in[0]-out[0];
        count=in[0];
        for(int i=1;i<n-1;i++){
            renshu=renshu-out[i]+in[i];
            count=count+renshu;
        }

        System.out.print(count);

    }
}
