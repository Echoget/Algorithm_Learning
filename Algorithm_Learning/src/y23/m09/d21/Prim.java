package y23.m09.d21;

import y23.m09.d20.Edge;
import y23.m09.d20.Graph;
import y23.m09.d20.Node;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 最小生成树 Prim算法（P算法）
 * 流程：点 -> 边 -> 点 -> 边 -> 点 -> ...
 */

public class Prim {
    // 主程序
    public static Set<Edge> primMST(Graph graph){

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        Set<Node> setNode = new HashSet<>();
        Set<Edge> setEdge = new HashSet<>();
        Set<Edge> res = new HashSet<>();
        // 外层for循环的作用是防森林
        for(Node cur : graph.nodes.values()){

            // cur是开始点，随便一个都可以
            if(!setNode.contains(cur)){
                setNode.add(cur);
                for(Edge edge : cur.edges){ // 由一个点解锁所有相连的边
                    if(!setEdge.contains(edge)){
                        setEdge.add(edge);
                        priorityQueue.offer(edge);
                    }
                }
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll(); // 弹出解锁的边中，最小的边
                    Node toNode = edge.to; // 可能为一个新的点，后面进行判断
                    if(!setNode.contains(toNode)){
                        setNode.add(toNode);
                        res.add(edge);
                        for(Edge edge1 : toNode.edges){
                            if(!setEdge.contains(edge1)){
                                setEdge.add(edge1);
                                priorityQueue.offer(edge1);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    // 自定义比较器
    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
