package PRAKTIKUM_ASD.Bab9;

import java.util.Random;

class Node {
    int data;
    Node nodeKiri;
    Node nodeKanan;

    public Node(int dt) {
        data = dt;
        nodeKiri = nodeKanan = null;
    }

    public void sisipDt(int dtSisip) {
        if (dtSisip < data) {
            if (nodeKiri == null)
                nodeKiri = new Node(dtSisip);
            else
                nodeKiri.sisipDt(dtSisip);
        } else if (dtSisip > data) {
            if (nodeKanan == null)
                nodeKanan = new Node(dtSisip);
            else
                nodeKanan.sisipDt(dtSisip);
        }
    }
}

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void sisipDtNode(int dtSisip) {
        if (root == null)
            root = new Node(dtSisip);
        else
            root.sisipDt(dtSisip);
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node == null)
            return;

        System.out.printf("%d ", node.data);
        preorder(node.nodeKiri);
        preorder(node.nodeKanan);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.nodeKiri);
        System.out.printf("%d ", node.data);
        inorder(node.nodeKanan);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.nodeKiri);
        postorder(node.nodeKanan);
        System.out.printf("%d ", node.data);
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countNodes(node.nodeKiri) + countNodes(node.nodeKanan);
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.nodeKiri == null && node.nodeKanan == null) {
            return 1;
        } else {
            return countLeaves(node.nodeKiri) + countLeaves(node.nodeKanan);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.nodeKiri);
            int rightHeight = getHeight(node.nodeKanan);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public static void main(String args[]) {
        Tree Tree = new Tree();
        int nilai;
        Random randomNumber = new Random();

        System.out.println("sisip nilai data berikut : ");

        for (int i = 1; i <= 10; i++) {
            nilai = randomNumber.nextInt(100);
            System.out.print(nilai + " ");
            Tree.sisipDtNode(nilai);
        }

        System.out.println("\n\nPreorder traversal");
        Tree.preorderTraversal();

        System.out.println("\n\nInorder traversal");
        Tree.inorderTraversal();

        System.out.println("\n\nPostorder traversal");
        Tree.postorderTraversal();
        System.out.println();

        System.out.println();
        System.out.println("Jumlah Node: " + Tree.countNodes());
        System.out.println("Jumlah Daun: " + Tree.countLeaves());
        System.out.println("Tinggi Pohon: " + Tree.getHeight());
    }
}