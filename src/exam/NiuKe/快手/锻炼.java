package exam.NiuKe.快手;

import java.util.*;

public class 锻炼 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] fangshi=new int[n];
        int[] xiaoguo=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            fangshi[i]=in.nextInt();
        }
        PriorityQueue<Integer[]> queue=new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return (o2[0]*2+o2[1])-(o1[0]*2+o2[1]);
            }
        });
        for(int i=0;i<n;i++){
            xiaoguo[i]=in.nextInt();
            Integer[] temp=new Integer[]{fangshi[i],xiaoguo[i]};
            queue.add(temp);
        }
        List<Integer[]> list=new ArrayList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }

//        PriorityQueue<Integer[]> queue2=new PriorityQueue<>(new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o2[0]-o1[0];
//            }
//        });
        Comparator<Integer[]> com=new Comparator<Integer[]>(){//外比较器   Comparable是内比较器
            @Override
            public int compare(Integer[] str1,Integer[] str2) {


                return str2[0]-str1[0];
            }
        };

        for(int i=0;i<n;i++){
            int temp=2*list.get(0)[0]+list.get(0)[1];
            List<Integer[]> tempList=new ArrayList<>(list.subList(0,i+1));
            Collections.sort(tempList,com);
            if(i>0){
                for(int j=1;j<tempList.size();j++){
                    temp=temp+tempList.get(j)[1];
                }
            }

            System.out.println(temp);
        }


    }
}
