import java.util.*;

class Solution26 {

    static final int[] D_X = {-1, 0, 1, 0};
    static final int[] D_Y = {0, -1, 0, 1};

    int eX;
    int eY;

    public int solution(String[] maps) {
        int sX = 0, sY = 0, lX = 0, lY = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    sX = i;
                    sY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    eX = i;
                    eY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lX = i;
                    lY = j;
                }
            }
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        int step = bfs(new Node(sX, sY, 0), lX, lY, maps, visited, false);
        if (step == -1) return -1;

        int sToE = bfs(new Node(sX, sY, step * 2), eX, eY, maps, visited, true);
        int lToE = bfs(new Node(lX, lY, step), eX, eY, maps, visited, true);

        if (lToE == -1) return sToE;
        else if (sToE == -1) return lToE;
        return Math.min(lToE, sToE);
    }

    private int bfs(Node node, int eX, int eY, String[] maps, boolean[][] visited, boolean refresh) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        if (refresh) {
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[i].length; j++)
                    visited[i][j] = false;
            }
        }

        while(!queue.isEmpty()) {

            Node n = queue.poll();

            if (n.x == eX && n.y == eY) return n.step;
            if (visited[n.x][n.y]) continue;

            visited[n.x][n.y] = true;

            for (int k = 0; k < 4; k++) {
                int newX = n.x + D_X[k];
                int newY = n.y + D_Y[k];

                if (validRange(newX, newY, maps, visited)) {
                    queue.add(new Node(newX, newY, n.step + 1));
                }
            }
        }
        return -1;
    }

    private boolean validRange(int x, int y, String[] maps, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < maps.length && y < maps[x].length()
                && !visited[x][y] && (maps[x].charAt(y) != 'X');
    }

    class Node {
        int x;
        int y;
        int step;

        Node (int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}