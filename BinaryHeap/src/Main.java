public class Main {

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(100); // O(1)
        heap.peek();
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);
        heap.extractHead();
        heap.levelOrder();
    }
}
