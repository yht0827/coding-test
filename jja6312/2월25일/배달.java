class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] map = new int[N + 1][N + 1];

        // 무한대로 초기화.
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if (i == j)
                    continue;
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        // 간선 정보 저장
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];

            if (map[a][b] > w) { // 최소거리로 저장시킨다.
                map[a][b] = w;
                map[b][a] = w;// 반대경우도 마찬가지.
            }
        }

        int[] dist = new int[N + 1];
        for (int i = 2; i < N + 1; i++) {
            dist[i] = (dist[i] == 0) ? Integer.MAX_VALUE : map[i][i];
        }

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        for (int i = 1; i < N; i++) {

            // dist중 방문하지 않았고 가장 작은 값을 가지는 인덱스 찾기
            int min_idx = 1;
            int min_value = Integer.MAX_VALUE;
            for (int j = 2; j <= N; j++) {
                if (!visited[j] && dist[j] < min_value) {
                    min_value = dist[j];
                    min_idx = j;
                }
            }

            visited[min_idx] = true;

            // 거쳐가는게 더 빠른지 확인
            for (int j = 2; j <= N; j++) {
                if (dist[j] > dist[min_idx] + map[min_idx][j]) {
                    dist[j] = dist[min_idx] + map[min_idx][j];
                }
            }
        }

        // 결과 카운트
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K)
                answer++;
        }

        return answer;
    }
}// Solution Class
