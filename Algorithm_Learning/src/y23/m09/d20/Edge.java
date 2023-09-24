package y23.m09.d20;

/**
 * 边结构的定义
 */

public class Edge {

    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
