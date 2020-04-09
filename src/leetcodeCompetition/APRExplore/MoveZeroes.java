package leetcodeCompetition.APRExplore;

public class MoveZeroes {
    /**
     * Move Zeroes
     * 一个含有0的数组，将该数组按照从小到大的顺序进行排序，其中0全部排在最后
     */
    public static void main(String[] args) {
        int[] a=new int[]{0,1,4,0,5,2,0};
        moveZeroes(a);
    }
    public static void moveZeroes(int[] nums) {
        //使用快排的思想，0作为无限大
        fastSort(nums,0,nums.length-1);
        System.out.println(nums);
    }
    public static void fastSort(int[] nums,int l,int r){
        if(l==r){
            return;
        }
        int index=nums[l];
        while(r>l){
            if(nums[r]!=0 && (index==0 || nums[r]<index)){
                swap(nums,l,r);
                while(l<r){
                    if(nums[l]==0 || (index!=0 && nums[l]>index)){
                        swap(nums,l,r);
                        r--;
                        break;
                    }else {
                        l++;
                    }
                }
            }else {
                r--;
            }
        }
        fastSort(nums,0,l-1);
        if(l<nums.length-1){
            fastSort(nums,l,nums.length-1);
        }

    }
    public static void swap(int[] a ,int i,int j){
        int temp =a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
