import java.util.LinkedList;
import java.util.Queue;

public class BST {

    BinaryTreeNode root;

    public BST() {
        this.root = null;
    }

    public void insert(int element) {
        root = insert(root, element);
    }

    private BinaryTreeNode insert(BinaryTreeNode root, int element) {
        if (root == null) {
            root = new BinaryTreeNode(element);
            return root;
        }

        if (root.data > element) {
            root.left = insert(root.left, element);
        } else {
            root.right = insert(root.right, element);
        }

        return root;
    }

    private void inorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    private void preorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);

        preorder(root.right);
    }

    private void postorder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder() {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.print("\nLevel Order : ");
        while (!queue.isEmpty()) {
            BinaryTreeNode presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if(presentNode.left != null) {
                queue.add(presentNode.left);
            }

            if(presentNode.right != null) {
                queue.add(presentNode.right);
            }

        }
    }

    public void inorder() {
        System.out.print("\nInorder : ");
        inorder(root);
    }

    public void preorder() {
        System.out.print("\nPreorder : ");
        preorder(root);
    }

    public void postorder() {
        System.out.print("\nPostorder: ");
        postorder(root);
    }

    private boolean search(BinaryTreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } else if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private BinaryTreeNode findParentNode(BinaryTreeNode root, int key) {
        if (root == null || root.data == key) {
            return null;
        }

        if (root.data > key) {
            if (root.left == null) {
                return null;
            }
            if (root.left.data == key) {
                return root;
            } else {
                return findParentNode(root.left, key);
            }
        } else {
            if (root.right == null) {
                return null;
            }
            if (root.right.data == key) {
                return root;
            } else {
                return findParentNode(root.right, key);
            }
        }

    }

    private BinaryTreeNode minimumNode(BinaryTreeNode root) {
        if(root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    private Boolean isChildless(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        return root.left == null && root.right == null;
    }

    private Boolean onlyLeftChild(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        return root.left != null && root.right == null;
    }

    private Boolean onlyRightChild(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        return root.left == null && root.right != null;
    }

    public void remove(int key) {
        if (root == null) {
            return;
        }

        deleteNode(null, root, key);
    }

    private void deleteNode(BinaryTreeNode parentNode, BinaryTreeNode currentNode, int key) {
        if(currentNode == null) {
            return;
        }
        if (key < currentNode.data) {
            deleteNode(currentNode, currentNode.left, key);
        } else if (key > currentNode.data) {
            deleteNode(currentNode, currentNode.right, key);
        } else {
            if (currentNode.right == null) {
                if (parentNode == null) {
                    root = currentNode.left;
                } else {
                    if (key < parentNode.data) {
                        parentNode.left = currentNode.left;
                    } else {
                        parentNode.right = currentNode.left;
                    }
                }
            } else {
                BinaryTreeNode replacingNode = minimumNode(currentNode.right);
                remove(replacingNode.data);
                replacingNode.left = currentNode.left;
                replacingNode.right = currentNode.right;
                if (parentNode == null) {
                    root = replacingNode;
                } else if (key < parentNode.data) {
                    parentNode.left = replacingNode;
                } else {
                    parentNode.right = replacingNode;
                }
            }
        }
    }

    public Integer findParent(int key) {
        BinaryTreeNode pvalue = findParentNode(root, key);

        if (pvalue != null) {
            return pvalue.data;
        } else {
            return null;
        }
    }

    private Integer height(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left != null && root.right != null) {
            return 1+ Math.max(height(root.left),height(root.right));
        } else if(root.left != null) {
            return 1 + height(root.left);
        } else if(root.right != null) {
            return 1+ height(root.right);
        } else {
            return 0;
        }
    }

    public Integer height() {
        return height(root);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(55);
        tree.insert(50);
        tree.insert(75);
        tree.insert(60);
//        tree.insert(85);
//        tree.insert(80);
//        tree.insert(95);
//        tree.insert(82);
//        tree.insert(76);

//        tree.insert(1);
//        tree.insert(4);
//        tree.insert(6);
//        tree.insert(10);

//        tree.preorder();
//        tree.postorder();
        tree.inorder();
        tree.remove(75);
        tree.levelOrder();
        System.out.print("\n" + tree.height());
    }
}
