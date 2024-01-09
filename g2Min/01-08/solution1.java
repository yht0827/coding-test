// k진수에서 소수 개수 구하기

class solution1 {
    public int solution(int n, int k) {
        String kNumber = Long.toString(n, k);

        String[] pArr = kNumber.split("0");

        int pCount = 0;

        for (String p : pArr) {
            if (p.isEmpty() || p.isBlank()) continue;

            if (isPrime(Long.parseLong(p))) pCount++;
        }
        return pCount;
    }

    public boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;

        int count = 0;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}