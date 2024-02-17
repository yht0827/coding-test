import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // k는 최고사과의 가치.
        // m은 묶음갯수
        // score는 arr.
        // 어레이를 정렬해서, 비싼사과부터 m개씩 묶는다.

        Arrays.sort(score);

        int lt = score.length - m;
        while (lt >= 0) {
            answer += score[lt] * m;
            lt -= m;
        }

        return answer;
    }
}