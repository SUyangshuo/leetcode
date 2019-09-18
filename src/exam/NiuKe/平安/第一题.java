package exam.NiuKe.平安;

import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        float a=Float.valueOf(s.split(" ")[0]);
        int b=Integer.valueOf(s.split(" ")[1]);

        double c= Double.valueOf(String.format("%.6f",mySqrt(a,b)));
        System.out.println(c);


    }
    public static double mySqrt(float x,int b) {
        if (x <= 0) return x;
        double low = 0.0;
        double high = x;
        double mid, sqrt;
        while (low <= high){
            high = Double.valueOf(String.format("%.7f",high));
            mid = Double.valueOf(String.format("%.7f",low + (high - low) / b));
            sqrt = Double.valueOf(String.format("%.7f",x / mid));

            if (sqrt == mid){
                return mid;
            } else if (sqrt < mid){
                high = mid - 0.000001;
            } else {
                low = mid + 0.000001;
            }
        }
        return high;
    }
}


