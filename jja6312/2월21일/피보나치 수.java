class Solution {
    public int solution(int n) {
        // 0 = 0
        // 1 = 0+1
        // 2 = 0+1
        // 3 = 1+1

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] % 1234567 + arr[i - 1] % 1234567;
        }

        int answer = arr[n] % 1234567;
        return answer;
    }
}