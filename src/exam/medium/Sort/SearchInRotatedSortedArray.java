package exam.medium.Sort;

public class SearchInRotatedSortedArray {
    /**
     *     33. Search in Rotated Sorted Array
     *     给定一个有序的数组，该数组有可能翻转 [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]
     *     给定一个值index 给出该值所在的位置，保证时间复杂度是logn
     *
     *     注意：使用了二分查找
     *     果左边的点比右边的点小，说明这两个点之间是有序的。
     　　　　　如果左边的点比右边的点大，说明中间有个旋转点，所以一分为二后，肯定有一半是有序的。所以还可以用二分法。
     判断出哪边是有序的后，index和有序那边的最大值比较，如果比最大值大说明在无序端，继续使用二分
     */

    public static void main(String[] args) {
        int[] b=new int[]{15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println(search2(b,25));
    }

    public static int search2(int[] nums, int target){
        if(nums.length<1){
            return -1;
        }
        int l=0;
        int r=nums.length-1;


        while(l!=r){
            int middle=(r+1-l)/2+l;
            if(middle==0 && nums[middle]!=target){
                return -1;
            }

            if(nums[l]==target){
                return l;
            }else if(nums[r]==target){
                return r;
            }else if(nums[middle]==target){
                return middle;
            }
            if((nums[l]<nums[middle-1] && nums[middle-1]>=target && nums[l]<target )||(nums[l]>nums[middle-1] &&( nums[middle]>target || nums[r]<target ) )){
                //说明左边有序且target在左边  或者是左边无序 右边有序 target在左边
                l=l;
                r=middle-1;
            }else  {
                //右边是有序的 并且target在右边 或者是右边无序  左边有序target在右边
               l=middle;
               r=r;
            }

        }
        if(l==r && nums[l]==target){
            return l;
        }
        return -1;

    }

}
