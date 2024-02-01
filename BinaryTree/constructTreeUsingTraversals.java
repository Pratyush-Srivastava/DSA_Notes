package BinaryTree;

public class constructTreeUsingTraversals {

    public static void main(String[] args) {
        int[] inorder = {40, 20, 50, 10, 30, 80, 70, 90};
        int[] preorder = {10, 20, 40, 50, 30, 70, 80, 90};
        int n = inorder.length;
        Node head = constructTreeUsingPreorderAndInorder(inorder, 0, n - 1, preorder, 0, n - 1);
        LevelOrderTraversal.printLevelOrderTraversal(head);
        System.out.println();
        InorderTraversal.inorderTraversal(head);
    }

    private static Node constructTreeUsingPreorderAndInorder(int[] inorder, int leftInorder, int rightInorder,
                                                             int[] preorder, int leftPreorder, int rightPreorder) {
        if (leftInorder > rightInorder) {
            return null;
        }
        int root = preorder[leftPreorder];
        int inorderRootIndex = indexOfRootInorder(inorder, root);
        Node node = new Node(root);
        node.left = constructTreeUsingPreorderAndInorder(inorder, leftInorder, inorderRootIndex - 1,
                preorder, leftPreorder + 1, leftPreorder + inorderRootIndex - leftInorder);
        node.right = constructTreeUsingPreorderAndInorder(inorder, inorderRootIndex + 1, rightInorder,
                preorder, leftPreorder + inorderRootIndex - leftInorder + 1, rightPreorder);
        return node;
    }

    private static int indexOfRootInorder(int[] inorder, int root) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }
}
