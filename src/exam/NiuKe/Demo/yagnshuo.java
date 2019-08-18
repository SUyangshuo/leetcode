package exam.NiuKe.Demo;

import java.util.Scanner;

public class yagnshuo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a=new int[]{11,13,15,17,19,21};
        dd(a,0,a.length);


    }
    public static void dd(int[] a,int l,int r){
        if(l==r){
            if(a[l]==19){
                System.out.println(l+1);
            }else{
                System.out.println("-1");
            }
            return;
        }
        int temp=l+(r-l)/2;
        if(a[temp]==19){
            System.out.println(temp+1);
        }else if(a[temp]<19){
            dd(a,temp+1,r);
        }else if(a[temp]>19){
            dd(a,l,temp-1);
        }

    }
}
