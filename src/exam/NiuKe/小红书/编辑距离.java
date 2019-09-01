package exam.NiuKe.小红书;


import java.util.*;

public class 编辑距离 {
    public  static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {


        int s=in.nextInt();
        List<List<List<Character>>> allresult=new ArrayList<>();
        int dd=0;
        while(s>0){

            String string1=in.next();
            String string2=in.next();
            LinkedList<Character> list1=new LinkedList<>();
            for(Character temp:string1.toCharArray()){
                list1.add(temp);
            }

            List<List<Character>> result=new ArrayList<>();
            int count=result.size();
            dfs(result,list1,string2,new ArrayList<>(),0,list1.size());
            if(result.size()==count){
                result.add(new ArrayList<>());
            }
            allresult.add(result);


            s--;
            dd++;

        }


        for(List<List<Character>> tempallList:allresult){
            System.out.println("{");
            for(List<Character> tempList:tempallList){
                if(!tempList.isEmpty()){
                    for(Character temp:tempList){
                        System.out.print(temp+" ");
                    }
                    System.out.println();
                }
            }
            System.out.println("}");
        }
    }

    public static void dfs(List<List<Character>> result
            ,LinkedList<Character> list
            ,String word2
            ,List<Character> caozuo
            ,int index
            ,int n
            ) {
        if(list.size()==word2.length()){
            StringBuffer st=new StringBuffer();
            for(Character temp:list){
                st.append(temp);
            }
            if(st.toString().equals(word2)){
                result.add(new ArrayList<>(caozuo));
            }
        }else{
            for(int i=index;i<n;i++){
                //选择删除
                Character tempchar=list.get(0);
                caozuo.add('d');
                list.remove(0);
                dfs(result,list,word2,caozuo,index+1,n);
                list.add(0,tempchar);
                caozuo.remove(caozuo.size()-1);
                //选择左移
                caozuo.add('l');
                dfs(result,list,word2,caozuo,index+1,n);
                caozuo.remove(caozuo.size()-1);
                //选择右移动
                caozuo.add('r');
                list.add(tempchar);
                dfs(result,list,word2,caozuo,index+1,n);
                list.remove(list.size()-1);
                caozuo.remove(caozuo.size()-1);
            }
        }
    }


}
