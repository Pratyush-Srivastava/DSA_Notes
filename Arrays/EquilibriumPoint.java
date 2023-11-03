package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquilibriumPoint {
    public static void main(String[] args) {
        System.out.println(equilibriumPoint(Arrays.asList(3, 4, 8, -9, 20, 6)));
        System.out.println(equilibriumPoint(Arrays.asList(4, 2, -2)));
        System.out.println(equilibriumPoint(Arrays.asList(4, 2, 2)));
    }

    private static int equilibriumPoint(List<Integer> integers) {
        if (integers.size() == 1) {
            return 0;
        }
        List<Integer> leftSum = new ArrayList<>();
        List<Integer> rightSum = new ArrayList<>();
        int currSum = 0;
        for (int i = 0; i < integers.size(); i++) {
            currSum += integers.get(i);
            leftSum.add(currSum);
        }
        currSum = 0;
        for (int i = integers.size() - 1; i >= 0; i--) {
            currSum += integers.get(i);
            rightSum.add(0, currSum);
        }
        for (int i = 0; i < integers.size(); i++) {
            if (i == 0) {
                if (rightSum.get(i + 1) == 0) {
                    return i;
                }
            } else if (i == integers.size() - 1) {
                if (leftSum.get(i - 1) == 0) {
                    return i;
                }
            } else if (leftSum.get(i - 1).equals(rightSum.get(i + 1))) {
                return i;
            }
        }
        return -1;
    }
}
