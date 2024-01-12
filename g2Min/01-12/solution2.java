//로또의 최고 순위와 최저 순위
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 순위에 따른 당첨 개수를 담은 배열
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        // 결과를 담을 배열, answer[0]: 최고 순위, answer[1]: 최저 순위
        int[] answer = new int[2];

        for (int i = 0; i < lottos.length; i ++) {
            if (lottos[i] == 0) {
                // 0인 경우, 알 수 없는 번호로 간주하여 최고 순위 증가
                answer[0]++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    // 일치하는 번호가 있으면 최고 순위와 최저 순위 모두 증가
                    answer[0]++;
                    answer[1]++;
                }
            }
        }

        // 순위에 따른 등수로 변환
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];

        return answer;
    }
}