package Arrays;

import java.util.Arrays;
import java.util.List;

public class MoveZerosToTheEnd {
    public static void main(String[] args) {
        System.out.println(moveZerosToTheEnd(Arrays.asList(8, 5, 0, 10, 0, 20)));
        System.out.println(moveZerosToTheEnd(Arrays.asList(0, 0, 0, 0, 10, 0)));
        System.out.println(moveZerosToTheEnd(Arrays.asList(10, 20)));
    }

    private static List<Integer> moveZerosToTheEnd(List<Integer> input) {
        boolean hasZeroArrived = false;
        int firstZero = -1;
        for (int iter = 0; iter < input.size(); iter++) {
            if (!hasZeroArrived && input.get(iter) == 0) {
                firstZero = iter;
                hasZeroArrived = true;
            }
            if (input.get(iter) != 0 && hasZeroArrived) {
                int temp = input.get(iter);
                input.set(iter, input.get(firstZero));
                input.set(firstZero, temp);
                firstZero++;
            }
            System.out.println(input + " iter = " + iter + " firstZero = " + firstZero + " hasZeroArrived = " + hasZeroArrived);
        }
        return input;
    }
}
