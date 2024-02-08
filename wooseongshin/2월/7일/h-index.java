import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int h = 0; h <= citations[citations.length - 1]; h++) {
            int below = belowCount(citations, h);
            int above = aboveCount(citations, h);
            if (below <= h && above >= h && answer < h) {
                answer = h;
            }
        }

        return answer;
    }

    private int belowCount(int[] citations, int h) {
        int count = 0;
        for (int citation : citations) {
            if (citation <= h) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private int aboveCount(int[] citations, int h) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= h) {
                count++;
            }
        }
        return count;
    }
}
