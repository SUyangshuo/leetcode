package exam.medium.Recurrence.DFS;

import java.util.*;

public class ReconstructItinerary {
    /**
     * 332. Reconstruct Itinerary
     *有一个行程单，包含了起始城市和降落城市，现在优化行程单，将全部城市游历一边，出发城市不变，
     *
     * 使用深度优先遍历，对相同出发点的不同降落点，按照字典序排序
     */
    Map<String, PriorityQueue<String>> map= new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket:tickets){
            map.computeIfAbsent(ticket[0],k->new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    public void dfs(String node){
        PriorityQueue<String> priorityQueue = map.get(node);
        while(priorityQueue!=null&&!priorityQueue.isEmpty())
            dfs(priorityQueue.poll());
        res.add(node);
    }
}
