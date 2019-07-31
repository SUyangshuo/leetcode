package exam.medium.Recurrence.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    /**
     * 300. Longest Increasing Subsequence
     * 给定一个没有排序的数组，求数组中最长的增长序列，不需要元素相邻，要求时间复杂度为on2  最好优化到onlogn
     * 方法一：dp  每个位置记录之前有多少个元素小于本身
     * 方法二：dp  维护一个有序序列保存信息（非最长递增子序列），每次插入替换按照二分查找
     */
    public static void main(String[] args) {
        int[] a=new int[]{3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lengthOfLIS2(a));
    }

    //方法一
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] dp=new int[nums.length];
        int max=0;

        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max){
                        max=dp[i];
                    }
                }
            }
        }
        return max;
    }
    //方法二：
    //todo:该方法非常巧妙
    public static int lengthOfLIS2(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        List<Integer> result=new ArrayList<>();//利用数组和集合可以指定位置替换的性质，并且b有序，利用二分查找替换，提议压缩时间复杂度

        result.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            if(nums[i]>result.get(result.size()-1)){
                result.add(nums[i]); //当新值大于b【i】的最大值的时候，b的长度增加
            }else if(nums[i]<result.get(result.size()-1)){
                //使用二分查找的时候  index/2的时候直接使用length 不要-1
                binarySearch(nums[i],result,result.size()/2);//当小于的时候，说明子序列的值可能要发生变化了
            }
        }
        return result.size();
    }
    //二分查找替换
    public static  void binarySearch(int number,List<Integer> list,int index){
        //对于查找的问题 要特别注意index=0 index=length-1 以及长度为0,1,2的情况，最好当做特殊情况处理掉
        if(list.size()==2){
            if(list.get(0)>number){
                list.set(0,number);
            }else if(list.get(0)<number){
                list.set(list.size()-1,number);
            }
            return;
        }
        while(true){
            //最好不要同时处理第一个元素和最后一个元素，会导致下一层判断大小判断不严格
            if(index==0  || index==list.size()-1){
                if(list.get(index)>number){
                    list.set(index,number);//list做元素替换，直接set
                }
                break;
            }
            if(index-1>=0 && index+1<list.size()){
                if(list.get(index)==number){
                    break;
                }
                if(list.get(index)>number && list.get(index-1)<number){
                    list.set(index,number);
                    break;
                }else if(list.get(index)>number){
                    index=index/2;
                }else if(list.get(index)<number){
                    index=index+(list.size()-index)/2;
                }
            }
        }

    }
}
