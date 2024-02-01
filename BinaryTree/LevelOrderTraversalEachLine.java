package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversalEachLine {
    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(new Node());
        while (queue.size() > 1) {
            Node node = queue.poll();
            if (node.data == null) {
                System.out.println();
                queue.offer(new Node());
            } else {
                System.out.print(node.data + " ");
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

    //10 null
    //null 20 30
    //20 30 null
    //30 null 8 7
    //null 8 7 6
    //8 7 6 null
    //7 6 null
    //6 null 9 15
    //null 9 15
    //9 15 null
    //15 null
    //null
}
