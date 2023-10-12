package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println("Tower of hanoi for n = 3");
        initializeTowerOfHanoi(3);
        System.out.println("Tower of hanoi for n = 4");
        initializeTowerOfHanoi(4);
        System.out.println("Tower of hanoi for n = 2");
        initializeTowerOfHanoi(2);
        System.out.println("Tower of hanoi for n = 1");
        initializeTowerOfHanoi(1);

    }

    private static void initializeTowerOfHanoi(int n) {
        printTowerOfHanoi(n, "A", "B", "C");
    }

    private static void printTowerOfHanoi(int n, String A, String B, String C) {
        if (n == 1) {
            System.out.println("Move 1 from " + A + " to " + C);
            return;
        }
        printTowerOfHanoi(n - 1, A, C, B);
        System.out.println("Move " + n + " from " + A + " to " + C);
        printTowerOfHanoi(n - 1, B, A, C);
    }
}


/*
There are 3 towers A,B,C. 1 is at bottom and n is at top.
for n = 1,
move 1 from A to C
for n = 2,
move 1 from A to B
move 2 from A to C
move 1 from B to C
for n = 3,
move 1 from A to C
move 2 from A to B
move 1 from C to B
move 3 from A to C
move 1 from B to A
move 2 from B to C
move 1 from A to C
for n = 4,
move 1 from A to B
move 2 from A to C
move 1 from B to C
move 3 from A to B
move 1 from C to A
move 2 from C to B
move 1 from A to B
move 4 from A to C
move 1 from B to C
move 2 from B to A
move 1 from C to A
move 3 from B to C
move 1 from A to B
move 2 from A to C
move 1 from B to C
 */


