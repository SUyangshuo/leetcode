package exam.NiuKe.小红书;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 魔法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int t=in.nextInt();
        int m=in.nextInt();
        Integer[] a=new Integer[n];

        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        if(t<n){
            System.out.print(-1);
        }
        //根据血量对怪物排序
        Comparator<Integer> com=new Comparator<Integer>(){//外比较器   Comparable是内比较器
            @Override
            public int compare(Integer str1,Integer str2) {
                return str2-str1;
            }
        };
        Arrays.sort(a,com);
        int x=a[0];
        if(m==t){
            System.out.print(x);
        }

        int wuli=t-m;//全部 物理伤害

        //一共t回合   m点法力没个法力伤害x    n只怪 求x

        while(x>0){
            int i=0;
            while(i<m){//m次魔法伤害

                int yushu=a[i]%x;
                int shang=a[i]/x;//这个怪物用几次魔法
                i=i+shang;

            }

        }




    }
}
