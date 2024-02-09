import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Point {
        int x, y, dist;
        boolean leverPulled;

        public Point(int x, int y, int dist, boolean leverPulled) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.leverPulled = leverPulled;
        }
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        Point start = null, lever = null, exit = null;

        // 지도에서 S, L, E 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S')
                    start = new Point(i, j, 0, false);
                else if (c == 'L')
                    lever = new Point(i, j, 0, false);
                else if (c == 'E')
                    exit = new Point(i, j, 0, false);
            }
        }

        int toLever = bfs(maps, start, lever, n, m);
        if (toLever == -1)
            return -1;

        int toExit = bfs(maps, lever, exit, n, m);
        if (toExit == -1)
            return -1;

        return toLever + toExit;
    }

    private int bfs(String[] maps, Point start, Point end, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start.x, start.y, 0, start.leverPulled));

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == end.x && current.y == end.y)
                return current.dist;
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, current.dist + 1, current.leverPulled));
                }
            }
        }
        return -1;
    }
}
