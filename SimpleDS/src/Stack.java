public class Stack<T> {

    NODE<T> head;
    NODE<T> bottom;
    int length;

    static class NODE<T> {
        T data;
        NODE<T> next;

        public NODE(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        head = null;
        bottom = null;
        length = 0;
    }

    public Stack(int size) {
        this();
        length = size;
    }

    public void push(T element) {
        length++;
        NODE<T> newNode = new NODE<>(element);

        if(head == null) {
            head = newNode;
            bottom = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if(head == null) {
            return;
        }
        length++;
        head = head.next;
    }

    public T peek() {
        if(head == null) {
            return null;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T search(T element) {
        if(head == null) {
            return null;
        }

        NODE<T> temp = head;

        while (temp != null) {
            if(temp.data == element) {
                return temp.data;
            }
            temp = temp.next;
        }

        return null;
    }

    public static <E> void print(E args) {
        if(args instanceof Integer) {
            System.out.println(args.toString());
        } else {
            System.out.println(args);
        }
    }

    public static void main(String[] args) {
        Stack<String> ms = new Stack<>();
        print(ms.isEmpty());
        ms.push("google");
        ms.push("udemy.com");
        ms.push("Discord");
        print(ms.peek());
        ms.pop();
        print(ms.peek());
        ms.pop();
        print(ms.peek());
        ms.pop();
        print(ms.peek());
    }
}
