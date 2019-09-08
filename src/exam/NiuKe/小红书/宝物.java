package exam.NiuKe.小红书;

import java.util.*;

public class 宝物 {
    public static int count;
    public static void main(String[] args) {

        TreeMap<Integer,PriorityQueue<Integer>> map=new TreeMap<>();

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[][] a=new int[n][2];
        for(int i=0;i<n;i++){
            int temp1=in.nextInt();
            int temp2=in.nextInt();
            a[i][0]=temp1;
            a[i][1]=temp2;
            map.computeIfAbsent(temp1,k->new PriorityQueue<>()).add(temp2);
        }

        Iterator iter = map.entrySet().iterator();
        List<Integer[]> list=new ArrayList<>();


        for(Map.Entry<Integer,PriorityQueue<Integer>> temp:map.entrySet()){
            int key=temp.getKey();
            for(Integer t:temp.getValue()){
                list.add(new Integer[]{key,t});
            }
        }
        dfs(list,new Stack<>(),0);
        System.out.println(count);

    }

    public static void dfs( List<Integer[]> list,Stack<Integer[]> stack,int index) {
        if(!stack.isEmpty()){
            count=Math.max(stack.size(),count);
        }
        while(index<list.size()){
            if(stack.isEmpty() || list.get(index)[0] >= stack.peek()[0] && list.get(index)[1] >= stack.peek()[1] ){
                stack.add(list.get(index));
                dfs(list,stack,index+1);
            }
            index++;
        }
        if(!stack.isEmpty()){
            stack.pop();
        }
        return;
    }
}
