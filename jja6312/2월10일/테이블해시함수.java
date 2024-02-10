import java.util.Arrays;

public class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] == b[col - 1]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[col - 1], b[col - 1]);
        });

        int hashValue = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i - 1][j] % i;
            }
            hashValue ^= sum;
        }

        return hashValue;
    }
}
