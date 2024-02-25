package Searching;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 */
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
            middle = low + (high - low) / 2; //Make sure you use this instead of (low+high)/2.
            // This will make sure the large inputs doesn't go out of integer bounds
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
