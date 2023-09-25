package y23.m09.d21;

import y23.m09.d20.Edge;
import y23.m09.d20.Graph;
import y23.m09.d20.Node;

import java.util.*;

/**
 * 最小生成树 kruskal算法（k算法） 核心：并查集
 * 最小连通树 不破换连通性的前提下，删掉最大权重的边
 * 无向图会少一侧
 */

public class Kruskal {

    // 主程序
    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for(Edge edge : graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> res = new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from, edge.to)){
                res.add(edge);
                unionFind.union(edge.from, edge.to);
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

    // 并查集
    public static class UnionFind {
        private HashMap<Node, Node> fatherMap;
        private HashMap<Node, Integer> sizeMap;

        public UnionFind(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Collection<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for(Node node : nodes){
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findFather(Node node){
            Deque<Node> stack = new ArrayDeque<>();
            while (node != fatherMap.get(node)){
                stack.push(node);
                node = fatherMap.get(node);
            }
            while (!stack.isEmpty()){
                Node cur = stack.pop();
                fatherMap.put(cur, node);
            }
            return node;
        }

        public boolean isSameSet(Node a, Node b){
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b){
            if(a == null || b == null){
                return;
            }

            Node aHead = findFather(a);
            Node bHead = findFather(b);

            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                // 小挂大，减少遍历链的高度，减少时间复杂度
                if(aSetSize > bSetSize){
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                    sizeMap.remove(bHead);
                }else {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                    sizeMap.remove(aHead);
                }

            }

        }

    }


}
