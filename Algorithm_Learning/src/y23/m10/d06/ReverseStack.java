package y23.m10.d06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 将一个栈逆序，且不用额外的复杂数据结构
 */

public class ReverseStack {
    public static void main(String[] args) {
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = 0;i < 10;i++){
            s.push(i);
        }
        //printStack(s);
        reverse(s);
        printStack(s);

    }

    public static void reverse(Deque<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int a = f(stack);
        reverse(stack);
        stack.push(a);

    }

    public static int f(Deque<Integer> stack){
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }else{
            int a = f(stack);
            stack.push(res);
            return a;
        }
    }

    public static void printStack(Deque<Integer> stack){
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println("------------------------------------");
    }
}
