package exam.NiuKe.Demo;

import java.util.*;

public class xinfeiF {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int[] list=new int[10];
        List<Integer> list2=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        boolean index=true;
        int i=0;
        while(i<s.length()){
            if(s.toCharArray()[i]>='0' && s.toCharArray()[i]<='9'){
                int temp=s.toCharArray()[i]-'0';

                while(s.toCharArray()[++i]>='0' && s.toCharArray()[i]<='9'){
                    temp=temp*10 + (s.toCharArray()[i]-'0');
                }

                index=false;
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                }else {
                    map.put(temp,1);
                }

                list2.add(temp);

            }
            i++;
        }
        if(index){
            System.out.print("-1");
            return;
        }
        list2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int j=0;j<list2.size();j++){

                for(int x=0;x<map.get(list2.get(i));x++){
                    System.out.print(list2.get(i));
                }

        }

    }
}
