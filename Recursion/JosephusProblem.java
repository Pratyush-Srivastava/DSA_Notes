package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JosephusProblem {
    static int[][] seq;

    public static void main(String[] args) {
        System.out.println(findSurvivorIterative(0, 7, 3, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6))));
        System.out.println(findSurvivorIterative(0, 4, 2, new ArrayList<>(Arrays.asList(0, 1, 2, 3))));

        System.out.println(findSurvivorRecursive(0, 7, 3, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6))));
        System.out.println(findSurvivorRecursive(0, 4, 2, new ArrayList<>(Arrays.asList(0, 1, 2, 3))));
    }

    private static int findSurvivorIterative(int iter, int n, int k, List<Integer> persons) {
        while (n != 1) {
            iter = iter + (k - 1);
            if (iter >= n) {
                iter = iter % n;
            }
            System.out.println("iter = " + iter + " n = " + n + " k = " + k + " persons = " + persons);
            persons.remove(iter);
            n = n - 1;
        }
        return persons.get(0);
    }

    private static int findSurvivorRecursive(int iter, int n, int k, List<Integer> persons) {
        if (n == 1) {
            return persons.get(0);
        }
        iter = iter + (k - 1);
        if (iter >= n) {
            iter = iter % n;
        }
        System.out.println("iter = " + iter + " n = " + n + " k = " + k + " persons = " + persons);
        persons.remove(iter);
        return findSurvivorRecursive(iter, n - 1, k, persons);
    }

}
