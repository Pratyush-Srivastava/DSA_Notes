package Arrays;

import java.util.List;

import static java.util.Arrays.asList;

public class LeftRotateByOne {
    public static void main(String[] args) {
        System.out.println(leftRotateArrayByOne(asList(1, 2, 3, 4, 5)));
        System.out.println(leftRotateArrayByOne(asList(30, 5, 20)));
    }

    private static List<Integer> leftRotateArrayByOne(List<Integer> input) {
        int temp = input.get(0);
        for (int iter = 0; iter < input.size() - 1; iter++) {
            input.set(iter, input.get(iter + 1));
        }
        input.set(input.size() - 1, temp);
        return input;
    }
}
