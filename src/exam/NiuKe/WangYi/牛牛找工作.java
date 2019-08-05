package exam.NiuKe.WangYi;

import java.util.*;

public class 牛牛找工作 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String nm = sc.nextLine();//工作数量 //小伙伴数量
        int n=0,m=0;
        if(nm.split(" ").length==2){
             n=Integer.valueOf(nm.split(" ")[0]);
             m=Integer.valueOf(nm.split(" ")[1]);
        }

        //工作难度和报酬
        Map<Integer,Integer> map=new HashMap<>();
        String[] AI=new String[m];
        int d,p;
        for(int i=0;i<n;i++){
            String DP = sc.nextLine();//工作难度 //工作报酬
            if(DP.split(" ").length==2){
                d=Integer.valueOf(DP.split(" ")[0]);
                p=Integer.valueOf(DP.split(" ")[1]);
                if((map.containsKey(d) && map.get(d)<p)|| !map.containsKey(d)){
                    map.put(d,p);
                }
            }
        }

        String DP = sc.nextLine();//小伙伴能力
        AI=DP.split(" ").clone();

        for(int i=0;i<AI.length;i++){
            Integer temp=Integer.valueOf(AI[i]);
            int max=0;
            for(Map.Entry<Integer,Integer> mapTemp:map.entrySet()){
                if(mapTemp.getKey()<=temp && max<mapTemp.getValue()){
                    max=mapTemp.getValue();
                }
            }
            System.out.println(max);
        }
    }
}

//
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[][] arr = new int[N][2];
//        TreeMap map = new TreeMap();
//        for(int i = 0; i < N; i++) {
//            arr[i][0] = sc.nextInt();
//            arr[i][1] = sc.nextInt();
//        }
//        Arrays.sort(arr, (e1, e2) -> (int)(e1[0] - e2[0]));
//        for(int i = 1; i < arr.length; i++) {
//            arr[i][1] = Math.max(arr[i-1][1], arr[i][1]);
//        }
//        for(int i = 0; i < arr.length; i++) {
//            map.put(arr[i][0], arr[i][1]);
//        }
//        for(int i = 0; i < M; i++) {
//            int ability = sc.nextInt();
//            Integer index = (Integer) map.floorKey(ability);
//            if(index != null) {
//                System.out.println(map.get(index));
//            } else {
//                System.out.println(0);
//            }
//        }
//    }
//}
