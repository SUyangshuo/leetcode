package exam.NiuKe.爱奇艺;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class afsdsda {
    public static long count;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] bijiao=new int[n];//排序组合的第一个元素是从1开始
        bijiao[0]=-1;
        Integer[] a=new Integer[n];//排列组合  排列组合的第一个元素是从1开始
        a[n-1]=n-1;
        bijiao[n-1]=3;
        for(int i=0;i<n-1;i++){
            bijiao[i]=in.nextInt();
            a[i]=i;
        }
        List<Integer[]> result=new ArrayList<>();
        permutation(result,a,0,bijiao,true);
        long tt= (long)Math.pow(10,9)+7;
        System.out.println(count%tt);

    }
    public static    void permutation(List<Integer[]> list, Integer[] a, int index,int[] bijiao,boolean j){
        if(index==a.length-1 && j){
            //判断是否符合要求
            Integer[] temp = a.clone();
            //判断temp是否符合要求
            if(judge(temp,bijiao)){
                count++;
            }
        }else for(int i=index;i<a.length;i++){
            swap(a,i,index);
            boolean tempboolean=true;
            if(i< a.length-1 && (bijiao[i]==1 && a[i]<=a[i+1]) ||(bijiao[index]==1 && a[index]<=a[index+1]) ){//说明i》i+1
                tempboolean= false;
            }
            if(i< a.length-1 && (bijiao[i]==0 && a[i]>=a[i+1]) || (bijiao[index]==0 && a[index]>=a[index+1])){
                tempboolean= false;
            }
            permutation(list,a,index+1,bijiao,tempboolean);
            swap(a,i,index);
        }

    }
    public static  void swap(Integer[] t,int a,int b){
        int temp=t[a];
        t[a]=t[b];
        t[b]=temp;
    }
    public static boolean judge(Integer[] a,int[] bijiao){
        for(int i=0;i<bijiao.length;i++){
            if(bijiao[i]==1 && a[i]<=a[i+1]){//说明i》i+1
                return false;
            }
            if(bijiao[i]==0 && a[i]>=a[i+1]){
                return false;
            }
        }
        return true;
    }
}
