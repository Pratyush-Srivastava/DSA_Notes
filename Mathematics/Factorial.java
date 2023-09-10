package Mathematics;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(0) == 1);
        System.out.println(factorial(1) == 1);
        System.out.println(factorial(2) == 2);
        System.out.println(factorial(3) == 6);
        System.out.println(factorial(4) == 24);
        System.out.println(factorial(5) == 120);

        System.out.println(factorialRecursive(0) == 1);
        System.out.println(factorialRecursive(1) == 1);
        System.out.println(factorialRecursive(2) == 2);
        System.out.println(factorialRecursive(3) == 6);
        System.out.println(factorialRecursive(4) == 24);
        System.out.println(factorialRecursive(5) == 120);
    }

    //time: O(n)
    //space: O(1)
    private static int factorial(int number) {
        int factorial = 1;
        while(number > 1) {
            factorial = factorial * (number);
            number = number - 1;
        }
        return factorial;
    }

    //time: O(n)
    //auxiliary space: O(n)
    private static int factorialRecursive(int number) {
        if(number > 1) {
            return number * factorialRecursive(number - 1);
        } else {
            return 1;
        }
    }
}
