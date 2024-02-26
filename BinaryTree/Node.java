package BinaryTree;

public class Node {
    protected Node left;
    protected Node right;
    protected Integer data;

    public Node(Integer data) {
        this.data = data;
    }

    public Node() {
    }

    public static Node initializeBinaryTree() {
        Node root = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);
        Node node3 = new Node(8);
        Node node4 = new Node(7);
        Node node5 = new Node(6);
        Node node6 = new Node(9);
        Node node7 = new Node(15);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        return root;
    }

}
