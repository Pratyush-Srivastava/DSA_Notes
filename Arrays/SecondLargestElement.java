package Arrays;

import java.util.Arrays;
import java.util.List;

public class SecondLargestElement {
    public static void main(String[] args) {
        System.out.println(secondLargestElement(Arrays.asList(2, 5, 9, 6, 1, 3)));
        System.out.println(secondLargestElement(Arrays.asList(2, 5)));
        System.out.println(secondLargestElement(Arrays.asList(0, 1, 2, 3, 4, 5, 6)));
        System.out.println(secondLargestElement(Arrays.asList(1, 1, 2, 2, 3, 3)));
        System.out.println(secondLargestElement(Arrays.asList(2, 2, 2, 2, 2)));
        System.out.println(secondLargestElement(Arrays.asList(20, 10, 20, 8, 12)));
    }

    private static int secondLargestElement(List<Integer> input) {
        int largest = 0;
        int secondLargest = -1;
        for (int index = 0; index < input.size(); index++) {
            Integer number = input.get(index);
            if (number < input.get(largest) && (secondLargest == -1 || number > input.get(secondLargest))) {
                secondLargest = index;
            } else if (number > input.get(largest)) {
                secondLargest = largest;
                largest = index;
            }
        }
        return secondLargest;
    }
}
