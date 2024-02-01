package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeftView {
    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(new Node());
        System.out.print(root.data + " ");
        while (queue.size() > 1) {
            Node node = queue.poll();
            if (node.data == null) {
                System.out.print(queue.peek().data + " ");
                queue.offer(new Node());
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    private static Node initializeBinaryTree() {
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
