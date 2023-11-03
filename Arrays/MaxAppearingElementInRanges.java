package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxAppearingElementInRanges {
    public static void main(String[] args) {
        System.out.println(maxAppearingElement(Arrays.asList(1, 2, 4), Arrays.asList(4, 5, 7)));
        System.out.println(maxAppearingElement(Arrays.asList(1, 2, 5, 15), Arrays.asList(5, 8, 7, 18)));
        System.out.println(maxAppearingElement(Arrays.asList(1, 2), Arrays.asList(5, 4)));
        System.out.println(maxAppearingElementFastestAlgo(Arrays.asList(1, 2, 4), Arrays.asList(4, 5, 7)));
        System.out.println(maxAppearingElementFastestAlgo(Arrays.asList(1, 2, 5, 15), Arrays.asList(5, 8, 7, 18)));
        System.out.println(maxAppearingElementFastestAlgo(Arrays.asList(1, 2), Arrays.asList(5, 4)));
    }

    //return smallest if multiple. order of complexity = O(n log n)
    private static int maxAppearingElement(List<Integer> left, List<Integer> right) {
        Collections.sort(left);
        Integer rightMin = Collections.min(right);
        int i = left.size() - 1;
        while (left.get(i) > rightMin) {
            i--;
        }
        return left.get(i);
    }

    //O(n)
    private static int maxAppearingElementFastestAlgo(List<Integer> left, List<Integer> right) {
        int[] frequency = new int[100];
        for (int i = 0; i < left.size(); i++) {
            frequency[left.get(i)] += 1;
            if (i < right.size() - 1) {
                frequency[right.get(i) + 1] -= 1;
            }
        }
        int currSum = 0;
        int[] prefixSum = new int[100];
        for (int i = 0; i < frequency.length; i++) {
            currSum = currSum + frequency[i];
            prefixSum[i] = currSum;
        }
        int max = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] > prefixSum[max]) {
                max = i;
            }
        }
        return max;
    }
}
