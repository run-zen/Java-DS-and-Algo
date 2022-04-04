import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVL {

    BinaryNode root;

    AVL() {
        root = null;
    }

    //preorder traversal
    public void preOrder(BinaryNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder() {
        preOrder(this.root);
    }

    // level order
    public void levelOrder(BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();
            if(currentNode != null) {
                System.out.print(currentNode.value + " ");
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void levelOrder() {
        levelOrder(root);
    }

    // search
    public boolean search(BinaryNode root, int key) {
        if (root == null) {
            return false;
        }

        if (key < root.value) {
            return search(root.left, key);
        } else if (key > root.value) {
            return search(root.right, key);
        } else {
            return true;
        }
    }

    public boolean search(int key) {
        return search(this.root, key);
    }

    // get height
    public int getheight(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }


    // rightRotation
    private BinaryNode rightRotate(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getheight(disbalancedNode.left), getheight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getheight(newRoot.left), getheight(newRoot.right));

        return newRoot;
    }

    // left rotation
    private BinaryNode leftRotate(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getheight(disbalancedNode.left), getheight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getheight(newRoot.left), getheight(newRoot.right));

        return newRoot;
    }

    private int getBalance(BinaryNode root) {
        if (root == null) {
            return 0;
        }

        return (getheight(root.left) - getheight(root.right));
    }

    private BinaryNode insertNode(BinaryNode root, int value) {
        if (root == null) {
            BinaryNode newNode = new BinaryNode(value);
            newNode.height = 1;
            return newNode;
        } else if (value < root.value) {
            root.left = insertNode(root.left, value);
        } else {
            root.right = insertNode(root.right, value);
        }

        root = balanceNode(root, value);
        return root;
    }

    public void insert(int value) {
        root = insertNode(this.root, value);
    }

    private Boolean isLeafNode(BinaryNode root) {
        if (root == null) {
            return null;
        }
        return root.left == null && root.right == null;
    }

    private Boolean hasTwoChild(BinaryNode root) {
        if (root == null) {
            return null;
        }
        return root.left != null && root.right != null;
    }

    private BinaryNode minimumNode(BinaryNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }

        return minimumNode(root.left);
    }

    private BinaryNode balanceNode(BinaryNode root, int value) {
        root.height = 1 + Math.max(getheight(root.left), getheight(root.right));
        int balance = getBalance(root);

        if (balance > 1 && value < root.left.value) {
            return rightRotate(root);
        }

        if (balance > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && value > root.right.value) {
            return leftRotate(root);
        }

        if (balance < -1 && value < root.right.value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    // delete node method

    private BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.right == null) {
                root = root.left;
            } else {
                BinaryNode successor = minimumNode(root.right);
                root.value = successor.value;
                root.right = deleteNode(root.right, successor.value);
            }
        }

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;

    }

    public void delete(int key) {
        root = deleteNode(root,key);
    }

    public void deleteTree() {
        root = null;
        System.out.print("\nAVL tree successfully deleted");
    }
}
