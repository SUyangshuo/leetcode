package exam.NiuKe.HuaWei;

import java.util.Scanner;

public class MN的乘最接近k {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String[] twoN=n.split(".");

        double dou=Double.valueOf(n);
        int tai=1000;
        if(Integer.valueOf(twoN[0])==0){
            tai=10000;
        }
        while(tai>0){
            if(dou*tai<10000){

            }else{
                tai--;
            }
        }


    }
}
