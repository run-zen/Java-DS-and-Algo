public class MYLinkedList {
    NODE head;

    static class NODE {
        int data;
        NODE next;

        NODE(int d) {
            data = d;
            next = null;
        }
    }

    public void printList() {
        NODE temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println("");
    }

    public void appendNode(int d) {
        NODE temp = head;

        if (temp == null) {
            NODE new_node = new NODE(d);
            new_node.next = head;
            head = new_node;

            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new NODE(d);


    }

    public void pushNode(int d) {
        NODE new_node = new NODE(d);

        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    public void insertAfter(NODE prev_node, int d) {
        if (prev_node == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        NODE new_node = new NODE(d);

        new_node.next = prev_node.next;
        prev_node.next = new_node;

    }

    public void deleteNode(int d) {
        NODE temp = head, prev = null;

        if (temp != null && temp.data == d) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != d) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }

    public void deleteNodeAt(int position) {
        if (head == null) {
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }

        NODE temp = head;

        for(int i =0; i < position-1;i++) {
            if(temp == null) {
                break;
            }
            temp = temp.next;
        }
        if(temp == null || temp.next == null) {
            return;
        }

        temp.next = temp.next.next;

    }

    public int length() {
        int len = 0;
        NODE temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public static void main(String[] args) {
        MYLinkedList mylist = new MYLinkedList();

        mylist.head = null;


        mylist.pushNode(2);
        mylist.pushNode(1);
        mylist.pushNode(3);
        mylist.insertAfter(mylist.head, 4);
        mylist.printList();
        System.out.println("List length : "+ mylist.length());

        mylist.deleteNodeAt(2);
        mylist.deleteNodeAt(2);
        mylist.printList();
        System.out.println("List length : "+ mylist.length());
    }
}
