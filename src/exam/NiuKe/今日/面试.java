package exam.NiuKe.今日;

import java.util.Arrays;

public class 面试 {
    public static void main(String[] args) {
                String string="1237534";
                char [] a=new char[string.length()];
                char [] b=new char[string.length()];
                for(int i=0;i<a.length;i++){
                    a[i]=string.charAt(i);
                    b[i]=a[i];
                }
                Arrays.sort(a);
                int index=0;
                boolean flag=true;
                char max='1';
                for(int i=0;i<a.length;i++){
                    if(a[i]!=string.charAt(i) && flag){
                        flag=false;
                    }
                    if(!flag && max<string.charAt(i)){
                        index=i;
                        max=string.charAt(i);
                    }
                }
                char temp=b[index];
                b[index]=b[index-1];
                b[index-1]=temp;
                char[] c=b.clone();
                Arrays.sort(c);
                for(int i=index+1;i<a.length;i++){
                    b[i]=c[i];
                }
                System.out.println(b);
            }

}
