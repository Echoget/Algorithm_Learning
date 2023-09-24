package y23.m09.d17;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

/**
 * 并查集实现
 */

public class UnionFindSet {

    public static class Node<V> {
        V value;
        public Node(V v){
            value = v;
        }
    }

    public static class UnionSet<V> {
        // V -> 节点
        public HashMap<V, Node<V>> nodes;
        // 找到每个节点的父亲节点
        public HashMap<Node<V>, Node<V>> parents;
        // 只有代表点才有记录
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values){
            for(V value : values){
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        // 从点cur开始往上找，一直找到不能再往上的代表点，将其返回
        // 重要优化：扁平化处理（将当前节点a到其parent节点node中间所有经过的节点（b、c、d...）的parent全部指向node）
        public Node<V> findFather(Node<V> cur){
            Deque<Node<V>> stack = new ArrayDeque<>();
            while (cur != parents.get(cur)){
                stack.push(cur);
                cur = parents.get(cur);
            }
            // 扁平化处理
            while(!stack.isEmpty()){
                parents.put(stack.pop(), cur);
            }
            return cur;
        }

        // 判断两个对象是否在同一个代表点下
        public boolean isSameSet(V a, V b){
            if(!nodes.containsKey(a) || !nodes.containsKey(b)){
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        // 将两个对象合并到一个代表点下
        public void union(V a, V b){
            if(!nodes.containsKey(a) || !nodes.containsKey(b)){
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                // 小挂大，减少遍历链的高度，减少时间复杂度
                if(aSetSize > bSetSize){
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                    sizeMap.remove(bHead);
                }else {
                    parents.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                    sizeMap.remove(aHead);
                }
            }

        }

    }

}
