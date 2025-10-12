package ASD.Materi;

import java.util.LinkedList;
import java.util.Queue;

class NodeBinaryTree {
    Object data;
    NodeBinaryTree left, right;

    public NodeBinaryTree(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    NodeBinaryTree root;

    public BinaryTree() {
        this.root = null;
    }

    void setRoot(NodeBinaryTree root) {
        this.root = root;
    }

    public void preorder() {
        System.out.println("Pre-order Traversal:");
        preorderRecursive(this.root);
        System.out.println();
    }

    private void preorderRecursive(NodeBinaryTree node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    public void inorder() {
        System.out.println("In-order Traversal:");
        inorderRecursive(this.root);
        System.out.println();
    }

    private void inorderRecursive(NodeBinaryTree node) {
        if (node == null)
            return;
        inorderRecursive(node.left);
        System.out.print(node.data + " ");
        inorderRecursive(node.right);
    }

    public void postorder() {
        System.out.println("Post-order Traversal:");
        postorderRecursive(this.root);
        System.out.println();
    }

    private void postorderRecursive(NodeBinaryTree node) {
        if (node == null)
            return;
        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.data + " ");
    }

    void levelOrder() {
        System.out.println("Level-order Traversal:");
        if (this.root == null)
            return;
        Queue<NodeBinaryTree> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            NodeBinaryTree node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }
}