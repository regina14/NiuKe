package CrackingCodeInterview;
import java.util.*;

//用两个栈实现队列
public class twoStacks {
    Deque<Integer> stk1 = new ArrayDeque<>();
    Deque<Integer> stk2 = new ArrayDeque<>();

    public void push(int node) {
        stk1.push(node);
    }

    public int pop() {
        if (stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }

    public static void main(String[] args) {

    }
}
