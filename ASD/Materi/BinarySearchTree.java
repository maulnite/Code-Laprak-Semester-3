package ASD.Materi;

public class BinarySearchTree {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.sisipDtNode(40);

        tree.preorderTraversal();
        System.out.println("Banyak Node: " + tree.countNodes());
        System.out.println("Banyak Daun: " + tree.countLeaves());
        System.out.println("");
    }
}

class Node {
    int data;
    Node nodeKiri, nodeKanan;

    Node(int data) {
        this.data = data;
        nodeKiri = nodeKanan = null;
    }

    void sisipDt(int dtSisip) {
        if (dtSisip < this.data) {
            if (nodeKiri == null) {
                nodeKiri = new Node(dtSisip);
            } else {
                nodeKiri.sisipDt(dtSisip);
            }
        } else if (dtSisip > this.data) {
            if (nodeKanan == null) {
                nodeKanan = new Node(dtSisip);
            } else {
                nodeKanan.sisipDt(dtSisip);
            }
        }
    }
}

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    void sisipDtNode(int dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
    }

    void preorderTraversal() {
        preorderRecursive(root);
    }

    void preorderRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preorderRecursive(node.nodeKiri);
        preorderRecursive(node.nodeKanan);
    }

    void inorderTraversal() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node node) {
        if (node == null) {
            return;
        }
        inorderRecursive(node.nodeKiri);
        System.out.println(node.data);
        inorderRecursive(node.nodeKanan);
    }

    void postorderTraversal() {
        postorderRecursive(root);
    }

    void postorderRecursive(Node node) {
        if (node == null) {
            return;
        }

        postorderRecursive(node.nodeKiri);
        postorderRecursive(node.nodeKanan);
        System.out.println(node.data);
    }

    int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countNodesRecursive(node.nodeKiri) + countNodesRecursive(node.nodeKanan);
        }
    }

    int countLeaves() {
        return countLeavesRecursive(root);
    }

    private int countLeavesRecursive(Node node) {
        if (node == null) {
            return 0;
        } else if (node.nodeKiri == null && node.nodeKanan == null) {
            return 1;
        } else {
            return countLeavesRecursive(node.nodeKiri) + countLeavesRecursive(node.nodeKanan);
        }
    }

    int getHeight() {
        return getHeightRecursive(root);
    }

    private int getHeightRecursive(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeightRecursive(node.nodeKiri);
            int rightHeight = getHeightRecursive(node.nodeKanan);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}