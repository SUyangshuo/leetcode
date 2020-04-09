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

        for(int i=0;i<nums.length;i++){
            fastSort(nums,0,nums.length-1,nums[i]);
        }
        System.out.println(nums);

    }
    public static void fastSort(int[] nums,int l,int r,int index){
        int temp=index;
        while(r>l){
            if(nums[r]!=0 && (index==0 ||nums[r]<index)){
                int temp1=nums[r];
                nums[r]=temp;
                nums[l]=temp1;
                while(l<r){
                    if(index!=0||nums[l]>index){
                        int temp2=nums[l];
                        nums[l]=temp;;
                        temp=temp2;

                    }else {
                        l++;
                    }
                }
            }else {
                r--;
            }
        }

    }
}
