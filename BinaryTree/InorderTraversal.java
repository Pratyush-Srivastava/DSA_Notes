package BinaryTree;

public class InorderTraversal {
    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(40);
        root.right = new Node(50);
        inorderTraversal(root);
    }
    protected static void inorderTraversal(Node root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
}
