package Arrays;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Fact: Number of Groups of 1 and Groups of 0 will always differ by max of 1 */

public class MinimumGroupFlips {
    public static void main(String[] args) {
        System.out.println(minimumGroupFlips(Arrays.asList(1, 1, 0, 0, 0, 1)));
        System.out.println(minimumGroupFlips(Arrays.asList(1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1)));
        System.out.println(minimumGroupFlips(Arrays.asList(1, 1, 1)));
        System.out.println(minimumGroupFlips(Arrays.asList(0, 1)));
    }

    private static List<Pair<Integer, Integer>> minimumGroupFlips(List<Integer> binaryNumbers) {
        List<Pair<Integer, Integer>> oneGroupFlips = new ArrayList<>();
        List<Pair<Integer, Integer>> zeroGroupFlips = new ArrayList<>();
        for (int i = 0; i < binaryNumbers.size(); i++) {
            int start = i;
            int end = i;
            while (i < binaryNumbers.size() - 1 && binaryNumbers.get(i).equals(binaryNumbers.get(i + 1))) {
                end++;
                i++;
            }
            if (binaryNumbers.get(i) == 0) {
                zeroGroupFlips.add(new Pair<>(start, end));
            } else {
                oneGroupFlips.add(new Pair<>(start, end));
            }
        }
        if (zeroGroupFlips.size() > oneGroupFlips.size()) {
            return oneGroupFlips;
        } else {
            return zeroGroupFlips;
        }
    }
}
