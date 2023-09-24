package y23.m09.d20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class DFSGraph {

    public static void dfs(Node node){
        if(node == null){
            return;
        }
        Deque<Node> s = new ArrayDeque<>();
        HashSet<Node> set = new HashSet<>();
        s.push(node);
        set.add(node);
        System.out.println(node.id);
        while (!s.isEmpty()){
            Node cur = s.pop();
            for (Node next : cur.nexts){
                if(!set.contains(next)){
                    s.push(cur);
                    s.push(next);
                    set.add(next);
                    System.out.println(next.id);
                    break;
                }
            }
        }

    }
}
