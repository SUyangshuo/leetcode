package exam.NiuKe.腾讯;

import javax.management.StringValueExp;
import java.util.*;

public class bingjiling {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();//n种配料
        int m=in.nextInt();//钱
        String[] w=new String[n];
        int[] v=new int[n];
        Map<String,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            w[j]=String.valueOf(in.nextInt())+"_"+String.valueOf(j);//第一位才是真实库存
        }
        int tempCount=0;
        for(int j=0;j<n;j++){
            v[j]=in.nextInt();
            map.put(w[j],v[j]);
            tempCount+=v[j];
        }
        //对n种配料排序 配料越少的在前边
        Comparator<String> com=new Comparator<String>(){//外比较器   Comparable是内比较器
            @Override
            public int compare(String str1,String str2) {
                int s1=Integer.valueOf(str1.split("_")[0]);
                int s2=Integer.valueOf(str2.split("_")[0]);
                return s1-s2;
            }
        };

        Arrays.sort(w,com);

        if(m<map.get(w[0])){
            System.out.println(w[0].split("_")[0]);
        }
        //从数量最多的开始遍历 记录平均数变化下需要多少钱
        int count=0;
        int max=Integer.valueOf(w[n-1].split("_")[0]);
        while(max>Integer.valueOf(w[0].split("_")[0])){
             count=0;
            boolean index=true;
            for(int i=0;i<n;i++){
                if(max>Integer.valueOf(w[i].split("_")[0])){
                    count+=(max-Integer.valueOf(w[i].split("_")[0]))*map.get(w[i]);
                    if (count>m) {
                        index=false;
                        break;
                    }
                }else {
                    break;
                }

            }
            if(!index){
                max--;
            }else {
                break;
            }
        }
        if(max==Integer.valueOf(w[n-1].split("_")[0])){
            m=m-count;
            max=(m/tempCount)+max;
        }
        System.out.println(max);
    }
}
