import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 몸무게를 오름차순으로 정렬
        int i = 0, j = people.length - 1; // 가장 가벼운 사람과 가장 무거운 사람의 인덱스
        int answer = 0; // 사용된 구명보트의 수

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 두 사람을 함께 보낼 수 있음
                i++;
            }
            j--;
            answer++;
        }

        return answer;
    }
}
