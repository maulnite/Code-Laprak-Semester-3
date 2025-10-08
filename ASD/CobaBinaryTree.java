package ASD;

public class CobaBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        NodeBinaryTree root = new NodeBinaryTree(15);

        root.left = new NodeBinaryTree(8);
        root.left.left = new NodeBinaryTree(2);
        root.left.right = new NodeBinaryTree(11);
        root.left.left.right = new NodeBinaryTree(6);
        root.left.left.right.left = new NodeBinaryTree(3);
        root.left.left.right.right = new NodeBinaryTree(7);
        root.left.right.left = new NodeBinaryTree(10);
        root.left.right.right = new NodeBinaryTree(12);
        root.left.right.right.right = new NodeBinaryTree(14);

        root.right = new NodeBinaryTree(20);
        root.right.right = new NodeBinaryTree(27);
        root.right.right.left = new NodeBinaryTree(22);
        root.right.right.right = new NodeBinaryTree(30);

        tree.setRoot(root);

        tree.preorder();
        tree.inorder();
        tree.postorder();
        tree.levelOrder();
    }
}
