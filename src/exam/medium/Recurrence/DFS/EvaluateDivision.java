package exam.medium.Recurrence.DFS;

import java.util.*;

public class EvaluateDivision {
    /**
     * 399. Evaluate Division
     * 描述：比较复杂，直观来看就是DFS
     *
     * 重点：
     *      方法一：使用功能DFS深度优先遍历，遍历一个带权重的图
     *      方法二：使用dp 唯一路径
     *
     */
    //方法一：
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //图的链式表示法
        Map<String, List<String>> pairs = new HashMap<>();
        //图上每条边的权重
        Map<String, List<Double>> valuedPairs = new HashMap<>();
        for(int i = 0 ; i < equations.size() ; i++) {
            //获取第i个方程式
            List<String> equation = equations.get(i);
            String multiplied = equation.get(0);//被除数
            String multiplier = equation.get(1);//除数
            //如果被除数从来没有添加到图中，则将其作为顶点在图中初始化
            if(!pairs.containsKey(multiplied)) {
                pairs.put(multiplied, new ArrayList<>());
                valuedPairs.put(multiplied, new ArrayList<>());
            }
            //如果除数从来没有添加到图中，则将其作为顶点在图中初始化
            if(!pairs.containsKey(multiplier)) {
                pairs.put(multiplier, new ArrayList<>());
                valuedPairs.put(multiplier, new ArrayList<>());
            }
            //添加边和边的权重
            pairs.get(multiplied).add(multiplier);
            pairs.get(multiplier).add(multiplied);
            valuedPairs.get(multiplied).add(values[i]);
            valuedPairs.get(multiplier).add(1.0 / values[i]);
        }

        //结果集
        double[] result = new double[queries.size()];
        for(int i = 0 ; i<queries.size() ; i++) {
            //在图中，以被除数作为顶点，深度优先遍历图，直到找到值为除数的顶点
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), pairs, valuedPairs, new HashSet<>(), 1.0);
            result[i] = result[i]==0.0 ? -1.0 : result[i];
        }
        return result;
    }

    public double dfs(String multiplied, String multiplier, Map<String, List<String>> pairs, Map<String, List<Double>> valuedPairs, Set<String> visited, double curResult) {
        //如果图中不包含该被除数顶点，则无法获知该表达式的值
        if(!pairs.containsKey(multiplied)) return 0.0;
        //如果再次访问过该被除数，说明找到了一条环路，则该深度优先遍历结果失败，直接抛弃
        if(visited.contains(multiplied)) return 0.0;
        //如果被除数等于除数，则返回1.0
        if(multiplied.equals(multiplier)) return curResult;
        visited.add(multiplied);
        //获得当前被除数的所有邻接顶点
        List<String> multipliers = pairs.get(multiplied);
        //获得所有邻接边的权重
        List<Double> multiplierValues = valuedPairs.get(multiplied);
        double tmp = 0.0;
        for(int i = 0 ; i<multipliers.size() ; i++) {
            //以邻接点为新的顶点，继续深度优先遍历
            //此时调用方法中curResult的值代表的是该原邻接点除以邻接点的值
            //如 a/b=2, b/c=3, 则a=2b，因此当我们以b作为邻接点寻找c时，需要记录原被除数是现被除数的两倍
            tmp = dfs(multipliers.get(i), multiplier, pairs, valuedPairs, visited, curResult * multiplierValues.get(i));
            //找到非零路径，结束深度优先遍历
            if(tmp != 0.0){
                break;
            }
        }
        visited.remove(multiplied);
        return tmp;
    }
}
