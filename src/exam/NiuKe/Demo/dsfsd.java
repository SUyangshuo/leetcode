package exam.NiuKe.Demo;

import java.util.Scanner;

public class dsfsd {




        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
            String s="爱讯飞789swr1wwen34ifly65tek";
            int[] list=new int[10];
            boolean index=true;
            for(char temp:s.toCharArray()){
                if(temp>='0' && temp<='9'){
                    index=false;
                    list[temp-'0']++;
                }
            }
            if(index){
                System.out.print("-1");
                return;
            }
            for(int i=0;i<10;i++){
                if(list[i]>0){
                    for(int j=0;j<list[i];j++){
                        System.out.print(i);
                    }
                }
            }

        }


}
