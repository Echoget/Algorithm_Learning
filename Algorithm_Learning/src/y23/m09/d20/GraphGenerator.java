package y23.m09.d20;

/**
 * 图结构转化
 */

public class GraphGenerator {

    // 有很多，以下只是一种

    // 1
    // matrix所有的边
    // N*3的矩阵
    // [weight,from节点上面的值,to节点上面的值]
    public static Graph createGraph1(int[][] matrix){
        Graph graph = new Graph();
        for(int i = 0;i < matrix.length;i++){
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];

            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    // 2


    // 3


    // 4


}
