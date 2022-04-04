import java.util.ArrayList;

public class ArrayStack<T> {

    ArrayList<T> arr;
    int length;

    public ArrayStack() {
        arr = new ArrayList<>(10);
        length = 0;
    }

    public ArrayStack(int size) {
        this();
        arr = new ArrayList<>(size);
    }

    public void push(T element) {
        length++;
        arr.ensureCapacity(length);
        arr.add(element);
    }

    public void pop() {
        length--;
        arr.remove(length);
    }

    public T peek() {
        if(length == 0) {
            return null;
        }
        return arr.get(length - 1);
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public static <E> void print(E args) {
        if(args instanceof Integer) {
            System.out.println(args.toString());
        } else {
            System.out.println(args);
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrStack = new ArrayStack<>();
        arrStack.push(3);
        arrStack.push(2);
        arrStack.push(1);
        arrStack.pop();
        arrStack.pop();
        print(arrStack.peek());
    }
}
