class Solution {
    private static final String PATTERN = "^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$";

    public int solution(String[] babbling) {
        int answer = 0;
        for (String s : babbling) {
            if (s.matches(PATTERN)) {
                answer++;
            }
        }
        return answer;
    }
}
