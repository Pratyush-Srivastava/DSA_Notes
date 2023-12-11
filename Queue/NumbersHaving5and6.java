package Queue;

import java.util.ArrayList;
import java.util.List;

public class NumbersHaving5and6 {
    public static void main(String[] args) {
        System.out.println(numbersHaving5And6(10));
        System.out.println(numbersHaving5And6(35));
    }

    private static List<String> numbersHaving5And6(int n) {
        List<String> numbersHaving5And6 = new ArrayList<>();
        numbersHaving5And6.add("5");
        numbersHaving5And6.add("6");
        numbersList(n, numbersHaving5And6, numbersHaving5And6);
        return numbersHaving5And6;
    }

    private static void numbersList(int n, List<String> currentNumbers, List<String> numbersHaving5And6) {
        if (numbersHaving5And6.size() < n) {
            int currentSize = numbersHaving5And6.size();
            List<String> modifiedNumbers = new ArrayList<>();
            for (int i = 0; i < currentNumbers.size(); i++) {
                String s = currentNumbers.get(i);
                modifiedNumbers.add(s.concat("5"));
                if (modifiedNumbers.size() + currentSize == n) {
                    break;
                }
                modifiedNumbers.add(s.concat("6"));
                if (modifiedNumbers.size() + currentSize == n) {
                    break;
                }
            }
            numbersHaving5And6.addAll(modifiedNumbers);
            numbersList(n, modifiedNumbers, numbersHaving5And6);
        }
    }
}
