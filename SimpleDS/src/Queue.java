public class Queue<T> {

    Stack.NODE<T> first;
    Stack.NODE<T> last;
    int length;

    static class NODE<T> {
        T data;
        Stack.NODE<T> next;

        public NODE(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        first = null;
        last = null;
        length = 0;
    }

    public Queue(int size) {
        this();
        length = size;
    }

    public void enqueue(T element) {
        length++;
        Stack.NODE<T> newNode = new Stack.NODE<>(element);

        if(first == null) {
            first = newNode;
            last = newNode;
            return;
        }

        last.next = newNode;
        last = newNode;
    }

    public void dequeue() {
        if(first == null) {
            return;
        }

        if(first == last) {
            first = null;
            return;
        }
        length--;
        first = first.next;
    }

    public T peek() {
        if(first == null) {
            return null;
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T search(T element) {
        if(first == null) {
            return null;
        }

        Stack.NODE<T> temp = first;

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
        Queue<String> ms = new Queue<>();
        print(ms.isEmpty());
        ms.enqueue("google");
        ms.enqueue("udemy.com");
        ms.enqueue("Discord");
        print(ms.peek());
        print(ms.search("google"));
        ms.dequeue();
    }
}
