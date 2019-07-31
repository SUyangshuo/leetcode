package exam.medium.Find.DinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution_FindPeakElement solution_findPeakElement=new Solution_FindPeakElement();
        int[] a=new int[]{1,2,3,4};
        solution_findPeakElement.findPeakElement(a);
    }
}

/**
 * 162. Find Peak Element
 * 利用二分查找  经典
 *
 * 一般来说还有其他几种方法：
 * 1：遍历数组，找到符合要求 的
 * 2：利用快排，找到最大的元素
 * 3：二分查找
 */
class Solution_FindPeakElement {
    /**
     * 最精简代码  思想就是把小的数排除在外
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
       if(nums.length==1){
           return 0;
       }
       //设置左右缩进指针
       int l=0;
       int r=nums.length-1;
       while(l<=r){
           if (l==r) {
               return l;
           }
           int temp=l+(r-l)/2;
           //把较小的元素剔除出去
           if(nums[temp]<nums[temp+1]){
               l=temp+1;
           }else{
               r=temp;
           }
       }
       return -l;
    }

    /**
     * 原始代码
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        if (nums[0] >= nums[1]) {
            return 0;
        }
        int len = nums.length;
        if (nums[len - 1] >= nums[len - 2]) {
            return len - 1;
        }
        int lo = 1, hi = len - 2;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
