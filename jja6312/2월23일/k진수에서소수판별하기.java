class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        // 10진수 n을 k진수로 변환
        String convertNum = Integer.toString(n, k);

        // "0"을 기준으로 split하여 각 부분이 소수인지 확인
        String[] parts = convertNum.split("0");

        for (String part : parts) {
            if (!part.isEmpty() && isPrime(Long.parseLong(part))) {
                answer++;
            }
        }

        return answer;
    }

    // 소수 판별 메서드
    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}