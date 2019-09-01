package exam.NiuKe.腾讯;

import java.util.*;

public class 消消乐 {
    public  static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int t=in.nextInt();
        List<String> result=new ArrayList<>();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            Map<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<n;j++){
                int shuru=in.nextInt();
                if(map.containsKey(shuru)){
                    map.put(shuru,map.get(shuru)+1);
                }else {
                    map.put(shuru,1);
                }
            }
            String r=solution(map);
            result.add(r);

        }
        for(String  string:result){
            System.out.println(string);
        }

    }
    public static String solution(Map<Integer,Integer> map) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //先把map中的valu放到队列中
        for(Map.Entry<Integer,Integer> temp:map.entrySet()){
            int value=temp.getValue();
            queue.add(value);
        }
        //队列中按照从到到小的顺序排好
        while(queue.size()>1){
            int temp1=queue.poll();
            int temp2=queue.poll();
            int temp=temp1-temp2;
            if(temp!=0){
                queue.add(temp);
            }
        }
        if(queue.size()==0){
            return "YES";
        }else{
            return "NO";
        }

    }
}
