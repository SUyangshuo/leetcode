package exam.medium.SlidingWindow;

public class FindtTheDuplicateNumber {
    /**
     * 287. Find the Duplicate Number
     * 给定一个包含n + 1个整数的数组，其中每个整数都在1和n之间(含)，证明至少有一个重复的数字必须存在。
     * 假设只有一个重复的数字，找出重复的那个。注意空间复杂度为1，时间复杂度小于n2，不可改变数组现有结构
     *
     * 重点：使用双指针法，一个快指针一个慢指针，两个速度相差一倍，如果两个指针相遇，说明存在有环，
     *      然后把其中一个指针从头指针开始，按照同样速度遍历，两个指针再次相遇的地方就是重复的值
     *
     *      证明：第二次相遇的点为重复点
     *      假设起点为a，入环点为b(重复点)，两个点在x相遇，现在证明x+ab=环周长
     *      慢指针在b点的路程为a+b,在环内路程为x，此时快指针走的路程为2ab+2x，可知，在环内由于快指针比慢指针速度快一倍，
     *      因此当两点相遇的时候，快指针比慢指针多绕环一周（整圈，不一定是一周）。在环内，慢指针路程为x，快指针路程为ab+2x，
     *      多行走的路程为ab+x，此时说明从x点走ab个路程就是b点
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];//这题可以改成用单链表的形式，使用数组，利用了数组下标，特使情况下可用
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
