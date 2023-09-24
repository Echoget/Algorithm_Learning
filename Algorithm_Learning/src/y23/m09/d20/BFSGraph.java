package y23.m09.d20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class BFSGraph {
    // 从node出发进行图的宽度优先遍历
    public static void bfs(Node node){
        if(node == null){
            return;
        }
        Deque<Node> q = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();//最大区别
        q.offer(node);
        set.add(node);
        while (!q.isEmpty()){
            Node n = q.poll();
            System.out.println(n.id);
            for(Node next : n.nexts){
                if(!set.contains(next)){
                    System.out.println(next.id);
                    q.offer(next);
                    set.add(next);
                }
            }
        }

    }
}
