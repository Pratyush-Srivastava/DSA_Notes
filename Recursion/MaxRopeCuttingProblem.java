package Recursion;

public class MaxRopeCuttingProblem {
    public static void main(String[] args) {
        System.out.println(maxPiecesOfRope(5, 2, 5, 1) == 5);
        System.out.println(maxPiecesOfRope(23, 12, 9, 11) == 2);
        System.out.println(maxPiecesOfRope(5, 4, 2, 6) == -1);
        System.out.println(maxPiecesOfRope(9, 2, 2, 2) == -1);
    }

    private static int maxPiecesOfRope(int n, int a, int b, int c) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        int maxPieces = Math.max(maxPiecesOfRope(n - a, a, b, c),
                Math.max(maxPiecesOfRope(n - b, a, b, c), maxPiecesOfRope(n - c, a, b, c)));
        if (maxPieces == -1) {
            return -1;
        } else {
            return 1 + maxPieces;
        }
    }
}


