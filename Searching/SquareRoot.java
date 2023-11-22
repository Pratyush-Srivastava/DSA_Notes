package Searching;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(36));
        System.out.println(squareRoot(49));
        System.out.println(squareRoot(81));
        System.out.println(squareRoot(121));
        System.out.println(squareRoot(35));
        System.out.println(squareRoot(3));
    }

    private static int squareRoot(int n) {
        int low = 1;
        int high = n;
        int middle = low;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (middle * middle == n) {
                return middle;
            } else if (middle * middle > n) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return middle;
    }
}
