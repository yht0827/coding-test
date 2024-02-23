import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers)
                .map(n -> n % 2 == 0 ? n + 1 : getSmallestLargerNumber(n))
                .toArray();
    }

    private long getSmallestLargerNumber(long n) {
        String binary = Long.toBinaryString(n);
        int zeroIndex = binary.lastIndexOf("0");
        String result;

        if (zeroIndex == -1) {
            result = "10" + binary.substring(1);
        } else {
            result = binary.substring(0, zeroIndex) + "10" + binary.substring(zeroIndex + 2);
        }

        return Long.parseLong(result, 2);
    }
}
