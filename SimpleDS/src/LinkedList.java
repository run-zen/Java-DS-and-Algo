public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        length = 0;
    }

    public LinkedList(T initial_data) {
        head = new Node<>(initial_data);
        tail = head;
        length = 1;
    }

    private Node<T> createNewNode(T data) {
        return new Node<>(data);
    }

    private Node<T> traverseToIndex(int index) {
        Node<T> temp = head;

        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void append(T data) {
        length++;
        Node<T> newNode = createNewNode(data);

        if(head == null) {
            head = newNode;
            tail = head;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void prepend(T data) {
        length++;
        Node<T> newNode = createNewNode(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insert(int index,T data) {
        if(index > length) {
            return;
        }

        if(index == 0) {
            this.prepend(data);
            return;
        }

        if(index == length) {
            this.append(data);
            return;
        }
        length++;

        Node<T> temp = this.traverseToIndex(index);

        if(temp == null) {
            return;
        }

        Node<T> newNode = createNewNode(data);

        newNode.next = temp;
        newNode.prev = temp.prev;
        temp.prev.next = newNode;
        temp.prev = newNode;

    }


    public void remove(int index) {
        if(index<0 || index > length || head == null) {
            return;
        }

        length--;
        if(index == 0) {
            head =head.next;
            if(head == null) {
                tail = null;
            }
            return;
        }

        if(index == length) {
            tail = tail.prev;
            tail.next = null;
            return;
        }


        Node<T> temp = this.traverseToIndex(index);

        if(temp == null) {
            return;
        }

        Node<T> deletedNode = temp;
        temp = deletedNode.prev;
        temp.next = deletedNode.next;
        if(deletedNode.next != null) {
            deletedNode.next.prev = temp;
        }

    }

    public void printList() {
        Node<T> temp = head;

        if (temp == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println();
        while (temp.next != null) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }

        System.out.print(temp.data);
    }

    public void reverse() {
        Node<T> temp = head;

        if(head == null || head.next == null) {
            return;
        }

        while (temp.next != null) {
            Node<T> swapper = temp.prev;
            temp.prev = temp.next;
            temp.next = swapper;
            temp = temp.prev;
        }

        Node<T> swapper = temp.prev;
        temp.prev = null;
        temp.next = swapper;

        tail = head;
        head = temp;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.append(10);
        ll.append(20);
        ll.append(40);
        ll.insert(2,30);
        ll.insert(4,50);
        ll.printList();

        LinkedList<String> ll2 = new LinkedList<>();
        ll2.append("Hi");
        ll2.append("I");
        ll2.append("Ranjan");
        ll2.insert(2,"am");
        ll2.insert(4,"Baruah");
        ll2.printList();
    }
}
