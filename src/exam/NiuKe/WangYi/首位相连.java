package exam.NiuKe.WangYi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 首位相连 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
//        Scanner sc2 =new Scanner(System.in);
//        String string=sc2.nextLine();
        int m=sc.nextInt();
        List<Integer> a=new ArrayList<>();
        List< List<Integer>> list=new ArrayList<>();
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                int tt=sc.nextInt();
                a.add(tt);
            }
            list.add(a);
        }
        for(List<Integer> tempList:list ){
            if(tempList.size()<3){
                System.out.println("NO");
                continue;
            }
            Collections.sort(tempList);
            if(tempList.get(tempList.size()-1) >=tempList.get(tempList.size()-2)+tempList.get(0)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }



    }

}
