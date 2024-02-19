class Solution {
    static int answer = 0;

    public int solution(int n) {

        for (int i = 1; i <= n; i++) {
            repeatPlusToN(i, n);
        }

        return answer;
    }

    private void repeatPlusToN(int i, int max) {
        int sum = 0;
        int index = i;
        while (sum < max) {
            sum += index;
            index++;
        }

        if (sum == max) {
            answer++;
        }
    }
}