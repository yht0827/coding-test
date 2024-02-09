import java.util.*;

class Solution {
    private static List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] result = moves.stream().toArray(int[][]::new);
        return result;
    }

    private static void hanoi(int disks, int startPeg, int auxiliaryPeg, int endPeg) {
        if (disks == 0) {
            return;
        }
        hanoi(disks - 1, startPeg, endPeg, auxiliaryPeg);
        moves.add(new int[]{startPeg, endPeg});
        hanoi(disks - 1, auxiliaryPeg, startPeg, endPeg);
    }
}
