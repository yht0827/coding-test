class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length; // 행의 개수

        // 각 행에 대해 가능한 최대 점수를 계산
        for (int i = 1; i < n; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][1], Math.max(land[i - 1][0], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][0]));
        }

        // 마지막 행에서 가능한 최대 점수 찾기
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[n - 1][i]);
        }

        return answer;
    }
}
