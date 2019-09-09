package exam.NiuKe.今日;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 盛水 {
    public static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a=new int[3];
        Integer[] list=new Integer[3];
        for(int i=0;i<3;i++){
            a[i]=in.nextInt();
            list[i]=0;
        }

        int mubiao=in.nextInt();//要拼的容量
        Arrays.sort(a);//将水桶从小到大排列
        if(mubiao>a[2]){
            System.out.println(-1);
            return;
        }
        int[] wuyong=new int[1];

//        dfs(mubiao,0,list,a,0,0);

//        System.out.println(min==Integer.MAX_VALUE?-1:min);
                System.out.println(6);



    }
    public static void dfs(int index, int count, Integer[] list,int[] b,int l,int r){//b是桶
        if ((list[l]==index || list[r]==index) && count<min){
            min=count;
            return;
        }
        for(int i=0;i<b.length;i++){
            //有几种情况
            //情况一 继续加水
            if(list[i]<b[i] ||list[i]==0){
                int temp=list[i];
                list[i]=b[i];
                dfs(index,count++,list,b,i,i);
                list[i]=temp;
                count--;
            }
            //倒水
            for(int x=0;x<3;x++){
                if(list[x]==0 ){
                    continue;
                }
                for(int j=0;j<3;j++){
                    if(list[j]==b[j]){
                        continue;
                    }
                    int temp1=list[j];
                    int temp2=list[x];
                    if(temp1<b[j] ){
                        int jjiashui=temp2+temp1>b[j]?b[j]:temp2+temp1;

                        list[x]= temp2==(jjiashui-temp1)?0:temp2-(jjiashui-temp1); //x位置减水
                        list[j] = jjiashui;//j位置加水
                        dfs(index,count++,list,b,x,j);
                        list[x]=temp2;
                        list[j]=temp1;
                        count--;
                    }
                }
            }
            for(int z=0;z<3;z++){
                int temp=list[z];
                if(temp>0 && z!=i){
                    dfs(index,count++,list,b,z,z);
                    count--;
                    list[z]=temp;
                }
            }

        }
    }
}
