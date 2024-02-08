import java.util.*;

class Solution {
    List<int[]> steps = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = {};
        moveHanoiTower(n, 1, 3, 2);
        answer = steps.toArray(new int[0][]);
        return answer;
    }

    private void moveHanoiTower(int n, int from, int to, int support) {
        if (n == 1) {
            steps.add(new int[] { from, to });
            return;
        }
        moveHanoiTower(n - 1, from, support, to);

        steps.add(new int[] { from, to });

        moveHanoiTower(n - 1, support, to, from);

    }
}