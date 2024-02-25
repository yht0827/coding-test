class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long start = x;

        for (int i = 0; i < n; i++) {
            answer[i] = start;
            start += x;
        }
        return answer;
    }
}