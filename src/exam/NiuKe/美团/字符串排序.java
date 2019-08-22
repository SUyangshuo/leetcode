package exam.NiuKe.美团;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class 字符串排序 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String string=in.nextLine();
        String string2=string;
        int zero=(string.length()-string2.replace(",,", "").length())/2;
        String[] newString=string.split(",");
        Map<Character,LinkedList<String>> result=new HashMap<>();


        for(int i=0;i<newString.length;i++){
            char  temp=newString[i].toCharArray()[0];
            if(result.containsKey(temp)){
                sortList(result.get(temp),newString[i],0,result.get(temp).size());
            }else {
                LinkedList<String> tempList=new LinkedList<>();
                tempList.add(newString[i]);
                result.put(temp,tempList);
            }

        }
        StringBuilder ll=new StringBuilder();
        if(zero>0){
            ll.append(",");
            zero--;
        }
        for(int i=26;i>=0;i--){
           if(result.containsKey((char)(i+'a'))){
               for(String temp:result.get((char)(i+'a'))){
                    ll.append(temp+",");
               }
           }
        }
        System.out.print(ll.toString().substring(0,ll.length()-1));


    }
    public static void sortList(LinkedList<String> list,String string,int star,int end){

        if(list.size()==0||star>=end){
            list.add(star,string);
            return;
        }
        int mind=star+(end-star)/2;
        String temp=list.get(mind);
        int length=Math.min(temp.length(),string.length());
        int i=1;
        while(i<length){
            if(temp.charAt(i)>string.charAt(i)){
                sortList(list,string,mind+1,end);
                return;
            }else if(temp.charAt(i)<string.charAt(i)){
                sortList(list,string,star,mind-1);
                return;
            }else {
                i++;
            }


        }
        if(i==length){
            if(temp.length()<string.length()){
                list.add(mind+1,string);
            }else {
                list.add(mind,string);
            }
            return;
        }
    }
}
