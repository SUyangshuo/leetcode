package exam.medium.Sort;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] a=new int[][]{{1,0}};
        canFinish2(2,a);
    }
    /**
     * 207:Course Schedule
     * 给定了全部课程数，和课程之间的前导关系，求全部课程是否可以满足前导关系
     *
     * 使用到了拓扑排序
     *
     * 设某个课程存在前导课程，说明该点的入度+1，将所有课程的前导关系梳理出来后，将入度为0的点放在队列中，
     * 然后不停的弹队列，和弹出元素相关的点入度-1， 然后再将入度为0 的点放在队列， 如此循环
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0 ){
            return false;
        }
        if(prerequisites == null || prerequisites.length==0){
            return true;
        }

        List<Integer> result=new ArrayList<>();
        int[] pre=new int[numCourses];

        //统计下每个课程的全部前导数
        for(int[] temp:prerequisites){
            pre[temp[0]]++;
        }
        Queue<Integer> quen=new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            if(pre[i]==0){
                quen.add(i);
                result.add(i);
            }
        }

        while(!quen.isEmpty()){
            int tempInt=quen.poll();
            for(int[] temp: prerequisites){
                if(temp[1]==tempInt){
                    pre[temp[0]]--;
                    if(pre[temp[0]] == 0){
                        quen.add(temp[0]);
                        result.add(temp[0]);
                    }
                }
            }
        }

        return result.size()==numCourses;
    }
    /**
     * 优化时间复杂度  已知的图结构进行压缩，遍历的时候可以少一些元素
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<Integer>(0));
        int[] in = new int[numCourses];
        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
            in[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(in[i] == 0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int t = q.poll();
            res.add(t);
            for(int g : graph.get(t)){
                in[g]--;
                if(in[g] == 0)
                    q.add(g);
            }
        }
        if(res.size() != numCourses)
            return new int[0];
        int[] r = new int[res.size()];
        for(int i=0; i<res.size(); i++)
            r[i] = res.get(i);
        return r;
    }

    /***
     * 210. Course Schedule II
     * 返回这个排列
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] canFinish2(int numCourses, int[][] prerequisites) {
        int[] resultN=new int[]{};

        if(numCourses <= 0 ){
            return resultN;
        }
        if(prerequisites == null || prerequisites.length==0){
            for(int i=0;i<numCourses;i++){
                resultN[i]=i;
            }
            return resultN;
        }

        List<Integer> result=new ArrayList<>();
        int[] pre=new int[numCourses];

        //统计下每个课程的全部前导数
        for(int[] temp:prerequisites){
            pre[temp[0]]++;
        }
        Queue<Integer> quen=new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            if(pre[i]==0){
                quen.add(i);
                result.add(i);
            }
        }

        while(!quen.isEmpty()){
            int tempInt=quen.poll();
            for(int[] temp: prerequisites){
                if(temp[1]==tempInt){
                    pre[temp[0]]--;
                    if(pre[temp[0]] == 0){
                        quen.add(temp[0]);
                        result.add(temp[0]);
                    }
                }
            }
        }
        if(result.size()==numCourses){
            resultN=new int[numCourses];
            int i=0;
            for(Integer temp:result){
                resultN[i++]=temp;

            }
            return resultN;
        }
        return resultN ;
    }
}
