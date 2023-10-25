package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrappingWater {
    public static void main(String[] args) {
        System.out.println(trappingRainWater(Arrays.asList(2, 0, 2)));
        System.out.println(trappingRainWater(Arrays.asList(3, 0, 1, 2, 5)));
        System.out.println(trappingRainWater(Arrays.asList(5, 4, 3, 2, 1)));
        System.out.println(trappingRainWater(Arrays.asList(1, 2, 3)));

    }

    private static int trappingRainWater(List<Integer> blocks) {
        List<Integer> lmax = new ArrayList<>();
        List<Integer> rmax = new ArrayList<>();
        int max = blocks.get(0);
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i) > max) {
                max = blocks.get(i);
            }
            lmax.add(max);
        }
        max = blocks.get(blocks.size() - 1);
        for (int i = blocks.size() - 1; i >= 0; i--) {
            if (blocks.get(i) > max) {
                max = blocks.get(i);
            }
            rmax.add(max);
        }
        int unitsOfWater = 0;
        for (int i = 1; i < blocks.size() - 1; i++) {
            unitsOfWater += Math.min(lmax.get(i), rmax.get(i)) - blocks.get(i);
        }
        return unitsOfWater;
    }
}
