import java.util.*;

class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        q.offer(x);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    // Remove and return top element
    public int pop() {
        return q.poll();
    }

    // Return top element without removing
    public int top() {
        return q.peek();
    }

    // Check whether stack is empty
    public boolean empty() {
        return q.isEmpty();
    }
}