package BinaryTree;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        Node root = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        LevelOrderTraversal.printLevelOrderTraversal(root);
    }

    private static Node sortedArrayToBST(int[] nums) {
        return insertToBST(nums, 0, nums.length - 1);
    }

    private static Node insertToBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;
        Node root = new Node(nums[middle]);
        root.left = insertToBST(nums, start, middle - 1);
        root.right = insertToBST(nums, middle + 1, end);
        return root;
    }
}
