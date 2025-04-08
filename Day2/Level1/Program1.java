import java.util.Stack;

public class Program1 {
    private final Stack<Integer> stackIn;
    private final Stack<Integer> stackOut;

    public Program1() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void enqueue(int x) {
        stackIn.push(x);
    }

    public int dequeue() {
        shiftStacks();
        if (stackOut.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackOut.pop();
    }

    public int peek() {
        shiftStacks();
        if (stackOut.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackOut.peek();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    public static void main(String[] args) {
        Program1 q = new Program1();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.enqueue(40);
        System.out.println(q.dequeue());
    }
}
