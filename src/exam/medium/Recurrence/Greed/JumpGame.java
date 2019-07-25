package exam.medium.Recurrence.Greed;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] a=new int[]{3,2,1,0,4};
        boolean result=solution.canJump(a);
        System.out.println(result);
    }
}

/**
 * 55:Jump Game
 * 给定一个数组，数组上的每个数字代表的是从该位置可以跳多少步,求是否可以跳到最后一个位置
 * 注意：使用贪心算法，不停的比较可以跳的最大位置，如果可以跳的最大位置不能到达下一个下标，或者小于等于0，return false
 */
class Solution{
    public boolean canJump(int[] nums) {
        if(nums.length<=0 || (nums.length>1 && nums[0]==0) || nums == null){
            return false;
        }
        if(nums.length==1 &&nums[0]== 0){
            return true;
        }
        int max=0;//可以跳的最大位置
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,i+nums[i]);
            if(max==nums.length-1){
                return true;
            }
            if(max<i+1 ||max < 0){
                return false;
            }

        }
        return true;
    }
}
