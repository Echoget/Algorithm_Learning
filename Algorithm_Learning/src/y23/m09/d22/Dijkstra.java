package y23.m09.d22;

import y23.m09.d20.Edge;
import y23.m09.d20.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Dijkstra算法
 */

public class Dijkstra {

    public static HashMap<Node, Integer> dijkstra1(Node from){
        // 从from出发到所有点的最小距离
        // key:从head出发到达的节点key
        // value:从head出发到key的最短距离
        // 如果在表中，没有相关记录，则代表该距离为正无穷，即不可到达
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(from, 0);

        Set<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);

        while (minNode != null){
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                }else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }

        return distanceMap;
    }

    // 寻找不在黑名单的节点中，距离from距离最短的节点
    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, Set<Node> selectedNodes){
        Node minNode = null;
        int minDistance = Integer.MIN_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!selectedNodes.contains(node) && distance < minDistance){
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

}
