package y23.m09.d20;

import java.util.ArrayList;

/**
 * 点结构的定义
 */

public class Node {
    public int id;
    // 入度的数量
    public int in;
    // 出度的数量
    public int out;
    // 邻居节点（从该点出发可以到达的直接节点）
    public ArrayList<Node> nexts;
    // 直接边（从该点出发的边）
    public ArrayList<Edge> edges;

    public Node(int id){
        this.id = id;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
