package exam.NiuKe.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class biaoge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        char[] c=s.toCharArray();
        int count=0;
        String temp="";
        int i=0;
        String index="!@#$%^&*()\",";
        String index2="!@#$%^&*()";

        List<String> list=new ArrayList<>();
        while(i<c.length-1){
            int firsti=i;
            if(!(c[i]>='0' && c[i]<='9') && !(c[i]>='a' && c[i]<='z') && !index.contains(String.valueOf(c[i]))){
                System.out.println("ERROR");
                break;
            }
            //字母 和其他符号
            if((c[i]>='a' && c[i]<='z') || index2.contains(String.valueOf(c[i]))){
                list.add(String.valueOf(c[i]));
                count++;
                i++;
                continue;
            }
            //数字
            while(c[i]>='0' && c[i]<='9'){
                temp=temp+String.valueOf(c[i]);
                i++;
            }
            if(temp.length()>0){
                list.add(temp.toString());
                temp="";
                count++;

                continue;
            }
            if(c[i]==','){
                if(i-1>0){
                    if(c[i-1]==','){
                        list.add("--");
                    }
                }
                i++;
                continue;
            }
            if(c[i]=='\"'){
                if(i-1>0){
                    if(c[i-1]==','){//说明下一个字符串有，或者有“
                        i++;
                        String temp2="";

                        while(i<c.length && i+1<c.length &&( c[i]!='\"' && c[i+1]!='\"')){

                                if(c[i]=='\"'&& c[i+1]=='\"'){
                                    temp2=temp2+"\"";
                                    i+=2;
                                }else{
                                    temp2=temp2+c[i];
                                    i++;

                                }
                        }
                        list.add(temp2);
                        continue;
                    }
                }
            }
            if(firsti==i){
                System.out.println("ERROR");
            }



        }
    }
}
