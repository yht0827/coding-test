// 성격 유형 검사

class solution2 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        char[] person = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' }; // 성격 유형
        int[] score = new int[8]; // 성격 유형 점수

        for (int i = 0; i < survey.length; i++) {
            char da = '\0';
            int s = choices[i]; // 선택지
            if (s < 4) { // 비동의 관련 선택지
                da = survey[i].charAt(0); // 첫 번째 캐릭터
                if (s == 1) {
                    s = 3;
                } else if (s == 3) {
                    s = 1;
                }
            } else if (s > 4) { // 동의 관련 선택지
                da = survey[i].charAt(1); // 두 번째 캐릭터
                s -= 4;
            } else {
                continue; // 모르겠음 선택 시 점수를 얻지 않음.
            }
            for (int j = 0; j < person.length; j++) {
                if (da == person[j]) {
                    score[j] += s; // 동일한 인덱스 값에 점수를 더하기
                }
            }
        }

        for (int i = 0; i < person.length; i = i + 2) {
            if (score[i] < score[i+1]) {
                answer += person[i+1];
            } else if (score[i] > score[i+1]) {
                answer += person[i];
            } else { // 성격 유형 점수가 같으면 사전 순으로 빠른 성격 유형
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