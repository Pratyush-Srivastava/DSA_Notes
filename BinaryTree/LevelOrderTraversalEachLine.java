package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversalEachLine {
    public static void main(String[] args) {
        Node root = initializeBinaryTree();
        System.out.println("Level order traversal using method 1 ");
        levelOrderTraversalEachLineUsingMethod1(root);
        System.out.println();
        System.out.println("Level order traversal using method 2 ");
        levelOrderTraversalEachLineUsingMethod2(root);
    }

    private static void levelOrderTraversalEachLineUsingMethod1(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        q.offer(new Node());
        while (q.size() != 1) {
            Node current = q.poll();
            if(current.data == null) {
                System.out.println();
                q.offer(new Node());
            } else {
                System.out.print(current.data + " ");
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
        }
    }

    private static void levelOrderTraversalEachLineUsingMethod2(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                System.out.print(current.data + " ");
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
            System.out.println();
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
