package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class CountOfSubsetSumK {
    public static void main(String[] args) {
        System.out.println(findSubsets(0, asList(1, 2, 3)));
        System.out.println(findSubsetsWithSumK(asList(1, 2, 3), 3));

        System.out.println(findSubsets(0, asList(10, 5, 2, 3, 6, 1)));
        System.out.println(findSubsetsWithSumK(asList(10, 5, 2, 3, 6, 1), 8));

        System.out.println(findSubsets(0, asList(10, 20, 15)));
        System.out.println(findSubsetsWithSumK(asList(10, 20, 15), 37));

        System.out.println(findSubsets(0, asList(10, 20, 15)));
        System.out.println(findSubsetsWithSumK(asList(10, 20, 15), 0));

    }
    private static int findSubsetsWithSumK(List<Integer> input, int sum) {
        int count = 0;
        List<Integer> sumOfEachSubset = findSumOfEachSubset(0, input, sum);
        for (Integer sumOfSubset: sumOfEachSubset) {
            if (sum == sumOfSubset) {
                count++;
            }
        }
        return count;
    }

    private static List<Integer> findSumOfEachSubset(int iter, List<Integer> input, int sum) {
        if (iter == input.size()) {
            return Collections.singletonList(0);
        }
        List<Integer> subsetsSum = new ArrayList<>();
        List<Integer> remainingSubsetsSum = findSumOfEachSubset(iter + 1, input, sum);
        for (Integer remainingSubsetSum : remainingSubsetsSum) {
            subsetsSum.add(remainingSubsetSum);
            subsetsSum.add(remainingSubsetSum + input.get(iter));
        }
        return subsetsSum;
    }

    private static List<List<Integer>> findSubsets(int iter, List<Integer> input) {
        if (iter == input.size()) {
            return Collections.singletonList(Collections.emptyList());
        }
        List<List<Integer>> subsets = new ArrayList<>();
        List<List<Integer>> remainingSubsets = findSubsets(iter + 1, input);
        for (List<Integer> remainingSubset : remainingSubsets) {
            subsets.add(remainingSubset);
            List<Integer> remainingSubsetWithCurrentValue = new ArrayList<>();
            remainingSubsetWithCurrentValue.add(input.get(iter));
            remainingSubsetWithCurrentValue.addAll(remainingSubset);
            subsets.add(remainingSubsetWithCurrentValue);
        }
        return subsets;
    }
}
