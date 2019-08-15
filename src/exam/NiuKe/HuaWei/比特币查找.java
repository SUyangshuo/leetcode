package exam.NiuKe.HuaWei;

import java.util.Scanner;

public class 比特币查找 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count=0;

        StringBuilder result=new StringBuilder();
        StringBuilder string=new StringBuilder();
        int j=-1;
        boolean index=true;
        while(n>1){
            string.append(n%2);
            n=n/2;
            j++;
            if(j>=2){

                if(string.toString().toCharArray()[j]=='1'
                        &&  string.toString().toCharArray()[j-1]=='0'
                        && string.toString().toCharArray()[j-2]=='1'){
                    if(index){
                        result.append(j-2);
                        index=false;

                    }
                    count++;
                }
            }
        }
        string.append(n);
        if(string.toString().equals("101")){
            System.out.println("1 0");
            return;
        }

        j++;
        if(j>=2 && string.toString().toCharArray()[j]=='1'
                &&  string.toString().toCharArray()[j-1]=='0'
                && string.toString().toCharArray()[j-2]=='1'){
            count++;
            result.append(j-2);
        }
        if(count==0){
            result.append("1-");
        }
        System.out.println(result.append(" "+count).reverse().toString());


    }
}
