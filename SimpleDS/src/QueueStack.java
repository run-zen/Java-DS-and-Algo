import java.util.Stack;

public class QueueStack<T> {  // Queue implementation using Stack

    Stack<T> stack1;
    Stack<T> stack2;

    public QueueStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T element) { // O(n)
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(element);
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
    }

    public T dequeue() { // O(1)
        return stack1.pop();
    }

    public boolean empty() {
        return stack1.empty();
    }

    public T peek() { // O(1)
        return stack1.peek();
    }

    public static void main(String[] args) {
        QueueStack<Integer> qs = new QueueStack<>();

        qs.enqueue(1);
        qs.enqueue(2);
        System.out.println(qs.peek());
        System.out.println(qs.dequeue());
        System.out.println(qs.empty());
    }
}
