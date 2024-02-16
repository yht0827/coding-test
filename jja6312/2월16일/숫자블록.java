class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        for (long i = begin; i <= end; i++) {
            answer[(int) (i - begin)] = getMaxDivisor(i);
        }
        return answer;
    }

    private int getMaxDivisor(long n) {
        if (n == 1)
            return 0;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return (int) (n / i);
            }
        }

        return 1;// 소수인경우 1을 리턴.
    }
}
