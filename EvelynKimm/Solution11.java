class Solution11 {
    public String solution(String new_id) {
        String answer;

        // 1
        answer = new_id.toLowerCase();
        // 2
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        // 3
        answer = answer.replaceAll("[.]{2,}", ".");
        // 4
        answer = answer.replaceAll("^[.]|[.]$", "");
        // 5
        if (answer.length() == 0) {
            answer += "a";
        }
        // 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }
        // 7
        if (answer.length() <= 2) {
            while (answer.length() <= 2) {
                answer += answer.charAt(answer.length() -1);
            }
        }
        return answer;
    }
}