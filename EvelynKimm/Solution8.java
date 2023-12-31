class Solution8 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        char[] person = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
        int[] score = new int[8];

        for (int i = 0; i < survey.length; i++) {
            char da = '\0';
            int s = choices[i];
            if (s < 4) {
                da = survey[i].charAt(0);
                if (s == 1) {
                    s = 3;
                } else if (s == 3) {
                    s = 1;
                }
            } else if (s > 4) {
                da = survey[i].charAt(1);
                s -= 4;
            } else {
                continue;
            }
            for (int j = 0; j < person.length; j++) {
                if (da == person[j]) {
                    score[j] += s;
                }
            }
        }

        for (int i = 0; i < person.length; i = i + 2) {
            if (score[i] < score[i+1]) {
                answer += person[i+1];
            } else if (score[i] > score[i+1]) {
                answer += person[i];
            } else {
                if (person[i] > person[i+1]) {
                    answer += person[i+1];
                } else {
                    answer += person[i];
                }
            }
        }

        return answer;
    }
}