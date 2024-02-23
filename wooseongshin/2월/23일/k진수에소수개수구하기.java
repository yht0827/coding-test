import java.util.*;

class Solution {
    private String convertToBase(int number, int base) {
        StringBuilder converted = new StringBuilder();
        while (number != 0) {
            converted.insert(0, number % base);
            number /= base;
        }
        return converted.toString();
    }

    private boolean isPrime(long number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int primeCount = 0;
        String baseConvertedNumber = convertToBase(n, k);
        String[] splitNumbers = baseConvertedNumber.split("0");

        for (String num : splitNumbers) {
            if (!num.equals("") && isPrime(Long.parseLong(num))) {
                primeCount++;
            }
        }
        return primeCount;
    }
}
