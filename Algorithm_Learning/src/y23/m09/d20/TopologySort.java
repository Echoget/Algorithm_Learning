package y23.m09.d20;

import java.util.*;

/**
 * 图的拓扑排序算法
 * 1、在图中找到所有入度为0的点输出
 * 2、把所有入度为0的点在图中删掉，继续找入度为0的点输出，周而复始
 * 3、图的所有点都被删除后，依次输出的顺序就是拓扑排序
 *
 * 要求：有向图且没有环
 * 应用：事件安排、编译顺序（文件依赖）
 */

public class TopologySort {
    public static List<Node> sortedTopology(Graph graph){
        // key:某一个node  value:剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 剩余入度为0的点，进入队列
        Deque<Node> zeroInQueue = new ArrayDeque<>();
        for(Node node : graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.offer(node);
            }

        }

        List<Node> res = new ArrayList<>();
        // 核心流程
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.offer(next);
                }
            }
        }
        return res;
    }
}
