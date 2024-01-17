class Solution33 {
    public int[] solution(int n, int m) {
        int[] answer;

        int max = Math.max(n, m);
        int min = Math.min(n, m);

        while (min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }

        int gcd = n * m / max;

        return new int[]{max, gcd};
    }
}
