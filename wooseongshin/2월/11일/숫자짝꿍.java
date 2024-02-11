class Solution {
    private static final int NUM_DIGITS = 10;
    private static final char ZERO_CHAR = '0';

    public String solution(String X, String Y) {
        int[] xCounts = getDigitCounts(X);
        int[] yCounts = getDigitCounts(Y);

        StringBuilder answer = buildAnswer(xCounts, yCounts);

        return formatAnswer(answer);
    }

    private int[] getDigitCounts(String str) {
        int[] counts = new int[NUM_DIGITS];
        for (char c : str.toCharArray()) {
            counts[c - ZERO_CHAR]++;
        }
        return counts;
    }

    private StringBuilder buildAnswer(int[] xCounts, int[] yCounts) {
        StringBuilder answer = new StringBuilder();
        for (int i = NUM_DIGITS - 1; i >= 0; i--) {
            int count = Math.min(xCounts[i], yCounts[i]);
            for (int j = 0; j < count; j++) {
                answer.append(i);
            }
        }
        return answer;
    }

    private String formatAnswer(StringBuilder answer) {
        if (answer.length() == 0) {
            return "-1";
        } else if (answer.charAt(0) == ZERO_CHAR) {
            return "0";
        } else {
            return answer.toString();
        }
    }
}
