package exam.NiuKe.WangYi;

import java.math.BigDecimal;
import java.util.Scanner;

public class 字符串碎片 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String string=sc.nextLine();

        char[] c=string.toCharArray();
        float t=1;
        float count=0;
        int temp=1;
        for(int i=1;i<c.length;i++){
            if(c[i]==c[i-1]){
                temp++;
            }else{
                t++;
                count+=temp;//加的是上一个的长度
                temp=1;
            }
        }
        count+=temp;

        System.out.println(count+"  "+t);
        System.out.println(new BigDecimal(count/t).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
