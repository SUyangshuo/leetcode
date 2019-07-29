package exam.medium.Recurrence.DFS.Permutations;

import java.util.*;

/**
 * 179. Largest Number
 * 根据给定的数组 给出数组能组成的最大值
 *
 * 有两种方法
 * 方法一：按照从最高位开始比较，对于最高位相同的比较次高位，
 *          但是存在一个问题，当最高位相同，但是位数不同的情况，需要比较 位数多的数除最高位以外的数和位数少的元素大小
 *  方法二：按照排列的方法，找出全部的组合，
 *          2.1对全部元素进行排列，但是容易超出长度
 *          2.2对 首位元素重复的位置排列 把首位元素相同的放在一个map中
 *          2.3 利用sort函数
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] a=new int[]{3,30,34,5,9};
        largestNumber(a);
    }
    public static  String largestNumber(int[] nums) {
        Map<String,List<Integer>> map=new HashMap<>();

        for(Integer temp:nums){
            Integer a=temp;
            String hight=String.valueOf(String.valueOf(temp).toCharArray()[0]);
            if(map.containsKey(hight)){
                map.get(hight).add(a);
            }else{

                List<Integer> list=new ArrayList<>();
                list.add(a);
                map.put(hight,list);
            }
        }
        //从9开始 取
        String result="";
        for(int i=9;i>0;i--){
            String j=String.valueOf(i);
            if(map.containsKey(j)){
                if(map.get(j).size()==1){
                    result+=map.get(j).get(0);

                }else{
                    List<String> tempResult=new ArrayList<>();
                    tempResult.add(String.valueOf(Long.MIN_VALUE));

                    Integer[] tempStrings = new Integer[map.get(j).size()];
                    map.get(j).toArray(tempStrings);

                    MaxNumber(tempStrings,0,tempResult);
                    result+=tempResult.get(tempResult.size()-1);
                }
            }
        }
        return result;
    }
    public static void MaxNumber(Integer[] list,int index,List<String> result){
        if(index==list.length){
            String tempMax="";
            for(Integer temp:list){
                tempMax=tempMax+String.valueOf(temp);
            }
            if(Long.parseLong(tempMax) > Long.parseLong(result.get(result.size()-1))){
                result.add(String.valueOf(tempMax));
            }
            return;
        }

        for(int i=index;i<list.length;i++){
            swap(list,index,i);
            MaxNumber(list,index+1,result);
            swap(list,index,i);
        }
    }
    public static void swap(Integer[] list,int i,int j){
        Integer temp=list[i];
        list[i]=list[j];
        list[j]=temp;
    }
    /**
     * 优化方法  使用sort函数
     */
    public String largestNumber2(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        String[] strings = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            strings[i]=nums[i]+"";
        }

        Arrays.sort(strings,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                String s1=o1+o2;
                String s2=o2+o1;
                return s2.compareTo(s1);
            }

        });
        if (strings[0].charAt(0) == '0') return "0";  //最前面的数为0，说明数组全部为0，这时候返回0
        StringBuilder reStringBuilder=new StringBuilder();
        for(int i=0;i<strings.length;i++){
            reStringBuilder.append(strings[i]);
        }
        //System.out.println(reStringBuilder.toString());
        return reStringBuilder.toString();
    }
}
