package exam.medium.Link;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    /**
     * 406. Queue Reconstruction by Height
     * 给定一些无序组合数，h，k   h表示身高，k表示在数组中的位置之前有多少个大于本身的元素，
     *
     * 先按照身高降序，身高相同相同的按照k增序排列，
     *
     * 注意。list在相同位置添加元素不会替换掉原元素，只会将元素后移
     *
     *
     */
    public static int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length==0 || people[0].length==0){
            return null;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }

        return res.toArray(new int[people.length][]);

    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0},{6,1}, {5,2}});
    }
}
