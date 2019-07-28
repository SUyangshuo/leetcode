package exam.medium.Find;

import javax.jws.soap.SOAPBinding;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution_FindPeakElement solution_findPeakElement=new Solution_FindPeakElement();
        int[] a=new int[]{2,1};
        solution_findPeakElement.findPeakElement(a);
    }
}

/**
 * 162. Find Peak Element
 * 利用二分查找
 */
class Solution_FindPeakElement {
    public int findPeakElement(int[] nums) {
       if(nums.length==1){
           return 0;
       }


        return judgePeek(nums,nums.length/2);
    }
    public Integer judgePeek(int[] nums,int index){
        if(index==0 && nums[1]<nums[index]){
            return 0;
        }else if(index==nums.length-1 && nums[nums.length-2]<nums[nums.length-1]){
            return nums.length-1;
        }else if(index==nums.length-1 || index==0){
            return null;
        }
        if(nums[index-1]<nums[index] && nums[index+1]<nums[index]){
            return index;
        }
        Integer a=judgePeek(nums,index/2);
        if(a!=null){
            return a;
        }
        Integer b=judgePeek(nums,index+(nums.length-index/2));

        if(a!=null){
            return a;
        }else {
            return b;
        }
    }
}
