import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution3 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int n, m;
    int[][] land;
    int[][] oil;
    boolean[][] visited;

    public int solution(int[][] land) {
        this.land = land;
        this.n = land.length;
        this.m = land[0].length;
        this.oil = new int[n][m];
        this.visited = new boolean[n][m];
        int[] oilPerColumn = new int[m];

        int oilId = 0;
        Map<Integer, Integer> oilSize = new HashMap<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int resultSize = bfs(i, j, oilId);
                    oilSize.put(oilId, resultSize);
                    oilId++;
                }
            }
        }

        for (int j=0; j<m; j++) {
            Set<Integer> oilSet = new HashSet<>();
            for (int i=0; i<n; i++) {
                if (land[i][j] == 1) {
                    oilSet.add(oil[i][j]);
                }
            }
            for (int id : oilSet) {
                oilPerColumn[j] += oilSize.get(id);
            }
        }
        return Arrays.stream(oilPerColumn)
                .max().getAsInt();
    }

    private int bfs(int x, int y, int oilId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        oil[x][y] = oilId;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i=0; i<4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >=0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    oil[nx][ny] = oilId;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}