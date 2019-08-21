package exam.NiuKe.bizhan;

import java.util.Scanner;

public class 复读机 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string =in.nextLine();
        String[] newString=string.split(" ");

        for(int i=0;i<newString.length;i++){
            if(newString[i].length()%2==1 && i!=newString.length-1){
                StringBuilder temp=new StringBuilder(newString[i]);
                System.out.print(temp.reverse()+" ");
            }else if(newString[i].length()%2==1 && i==newString.length-1){
                StringBuilder temp=new StringBuilder(newString[i]);
                System.out.print(temp.reverse());
            }else if(newString[i].length()%2==0 && i==newString.length-1){
                StringBuilder temp=new StringBuilder(newString[i]);
                System.out.print(temp.toString());
            }else{
                StringBuilder temp=new StringBuilder(newString[i]);
                System.out.print(temp.toString()+" ");
            }
        }
    }
}
