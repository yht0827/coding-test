import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public static Map<Integer, Integer> reserves = new HashMap<>();
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] visited;
    public static int order = 1;

    public int solution(int[][] land) {
        visited = new int[land.length][land[0].length];
        int answer = 0;
        calculateOil(land);

        for (int i = 0; i < land[0].length; i++) {
            int colReserves = 0;
            boolean[] counted = new boolean[order];
            for (int j = 0; j < land.length; j++) {

                if (land[j][i] == 1) {
                    if (!counted[visited[j][i]]) {
                        colReserves += reserves.get(visited[j][i]);
                        counted[visited[j][i]] = true;
                    }
                }
            }
            answer = Math.max(answer, colReserves);
        }

        return answer;
    }

    public void calculateOil(int[][] land) {        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(land, i, j);
                }
            }
        }
    }

    public void bfs(int[][] land, int row, int col) {
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{row, col});
        visited[row][col] = order;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length || visited[nx][ny] != 0) {
                    continue;
                }
              
                if (land[nx][ny] == 1) {
                    visited[nx][ny] = order;
                    queue.offer(new int[]{nx, ny});
                    count++;    
                }
            }
        }
        reserves.put(order, count);
        order++;
    }
}
