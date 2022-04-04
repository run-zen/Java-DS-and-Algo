public class BinaryNode {
    public int value;
    public int height;
    public BinaryNode left;
    public BinaryNode right;

    BinaryNode() {
        this.height = 0;
    }
    BinaryNode(int value) {
        this();
        this.value = value;
    }

}
