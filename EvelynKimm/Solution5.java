import java.util.Arrays;

class Solution5 {
    public int solution(int[] people, int limit) {
        int totalWeight = 0;
        int answer = 0;

        Arrays.sort(people);

        int minPosition = 0;
        int maxPosition = people.length-1;

        while(minPosition <= maxPosition) {
            // sort된 배열 중 "가장 적은 몸무게 + 가장 큰 몸무게"가 limit보다 작으면
            // 몸무게가 작은 사람도 탑승
            if(people[minPosition] + people[maxPosition] <= limit) {
                minPosition++;
            }
            // 몸무게가 큰 사람은 항상 탑승
            maxPosition--;
            answer++;
        }
        return answer;
    }
}