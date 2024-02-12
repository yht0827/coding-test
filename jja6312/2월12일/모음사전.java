class Solution {
    public int solution(String word) {
        // AEIOU
        char[] isAEIOU = { 'A', 'E', 'I', 'O', 'U' };
        int[] weight = { 781, 156, 31, 6, 1 };

        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (word.charAt(i) == isAEIOU[j]) {
                    answer += 1 + j * weight[i];
                }
            }
        }

        return answer;
    }
}