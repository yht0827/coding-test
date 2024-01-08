class Solution15 {
    public int solution(int n, int k) {
        String kNumber = Long.toString(n, k);

        String[] parsedArr = kNumber.split("0");

        int cnt = 0;

        for (String num : parsedArr) {
            if (num.isEmpty() || num.isBlank()) continue;

            if (isPrime(Long.parseLong(num))) cnt++;
        }
        return cnt;
    }

    public boolean isPrime(long n) {
        if (n<=1) return false;
        else if (n==2) return true;
        for (int i=2; i<= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}