package exam.medium.Rule;

public class GasStation {


}
/**
 * 134. Gas Station
 * 在一条回路上，有n个加油站，每个加油站的油量为gas[i]，从油站i到油站i+1的耗油量为cost[i],给定gas数组和cost数组，
 * 返回能够可以环绕这条回路的油站的索引，若不能环绕，则返回-1
 */
class Solution_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i] && enough(gas,cost,i)){
                return i;
            }
        }

        return -1;
    }
    //判断油量是否够用
    public boolean enough(int[] gas,int[] cost,int index){
        int a=0;
        int b=0;

        for(int i=0;i<gas.length;i++){

            int newindex=(i+index)%gas.length;
            a+=gas[newindex];
            b+=cost[newindex];
            if(a>=b){
                continue;
            }else {
                return false;
            }
        }

        return true;
    }
    //优化：只需要一次循环
    public int enough(int[] gas,int[] cost){
        int start = 0; // 起始位置
        int remain = 0; // 当前剩余燃料
        int debt = 0;// 前面没能走完的路上欠的债

        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                debt += remain;
                start = i + 1;
                remain = 0;
            }
        }
        return remain + debt >= 0 ? start : -1;
    }

}
