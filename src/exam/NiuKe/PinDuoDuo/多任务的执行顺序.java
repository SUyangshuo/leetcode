package exam.NiuKe.PinDuoDuo;

import java.util.*;

public class 多任务的执行顺序 {
    //给定n个任务 不同任务之间有先后执行顺序，求平均消耗时间最好少的任务顺序

    /**
     * 拓扑排序+优先队列
     * 当多个元素同时进入队列时间，使用优点队列进行预排序
     */

        static class Task {
            int seq;
            int weight;
            public Task(int n, int w) {
                seq = n;
                weight = w;
            }
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                int n = in.nextInt();
                int m = in.nextInt();
                Task[] t = new Task[n+1];
                for(int i = 1; i < n+1; ++i) {
                    t[i] = new Task(i, in.nextInt());
                }
                // construct dependency raph
                Map<Integer, List<Integer>> graph = new HashMap<>();
                int[] indegree = new int[n+1];
                for(int i = 0; i < m; ++i) {
                    int u = in.nextInt();
                    int v = in.nextInt();
                    if(graph.containsKey(u)) {
                        graph.get(u).add(v);
                    } else {
                        List<Integer> edges = new ArrayList<>();
                        edges.add(v);
                        graph.put(u, edges);
                    }
                    indegree[v]++;
                }
                //topological sort
                PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
                    public int compare(Task o1, Task o2) {
                        int n=o1.weight-o2.weight;
                        if( n==0){   //保证在w相同的时候选择字典序小的
                            n=o1.seq-o2.seq;
                        }
                        return n;
                    }
                });
                for(int i = 1; i < n+1; ++i) {
                    if(indegree[i] == 0) queue.offer(t[i]);
                }
                List<Integer> res = new ArrayList<>();
                while(!queue.isEmpty()) {
                    Task complete = queue.poll();
                    res.add(complete.seq);
                    if(graph.containsKey(complete.seq)) {
                        for(int i : graph.get(complete.seq)){
                            if(--indegree[i] == 0) {
                                queue.offer(t[i]);
                            }
                        }
                    }
                }
                for(int i = 0; i < n; ++i) {
                    System.out.print(res.get(i));
                    if(i != n-1) System.out.print(" ");
                }
            }
        }
}
