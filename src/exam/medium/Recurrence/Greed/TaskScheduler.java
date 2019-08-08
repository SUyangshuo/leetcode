package exam.medium.Recurrence.Greed;

import java.util.Arrays;

public class TaskScheduler {
    /**
     * 621. Task Scheduler
     * 模拟CPU任务分配，A 到 Z表示不同的任务，任务可以以不同顺序进行。
     * 每个任务可以在一个时间间隔中完成。对于一个时间间隔，CPU可以执行一个任务或者是闲置。
     * 但是，两个同样的任务之间需要有 n 个冷却时间，也就是说假如A执行后，
     * 那么未来n个时间间隔内，A是不允许再执行的。
     *
     *使用贪心法，先对字母按照词频排序，每次取一个词频最大的分配，
     *      tasks.length或(c[25] - 1) * (n + 1) + 25 – i中大的那个
     *
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;//这是为浏览统计出来和最高词频相同频率的单词
        //首先可知，只要最高词频的间隔满足要求，其他字母就满足要求

        // (c[25] - 1) * (n + 1)是最高词频满足要求的长度， 25 - i代表等于最高词频的字母数，
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
