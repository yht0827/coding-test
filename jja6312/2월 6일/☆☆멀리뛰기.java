public class Solution {
    public long solution(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        long[] ways = new long[n + 1];
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % 1234567;
        }

        return ways[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4)); // 5
        System.out.println(solution.solution(3)); // 3
    }
}
