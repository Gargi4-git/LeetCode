import java.util.*;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    private void transfer() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public int pop() {
        transfer();

        if (s2.isEmpty()) {
            return -1;
        }

        return s2.pop();
    }

    public int peek() {
        transfer();

        if (s2.isEmpty()) {
            return -1;
        }

        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}