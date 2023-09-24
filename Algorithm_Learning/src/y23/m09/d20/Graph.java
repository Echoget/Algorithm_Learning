package y23.m09.d20;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图结构的定义
 */

public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
