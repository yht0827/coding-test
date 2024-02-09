import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static String[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 , -1, 1};
    
    public int solution(String[] maps) {
        int mapHeight = maps.length;
        int mapWidth = maps[0].length();
        maze = new String[mapHeight][mapWidth];
        int[] start = new int[2];
        int[] labor = new int[2];

        for(int i = 0; i < mapHeight; i++) {
            String[] row = maps[i].split("");
            
            for(int j = 0; j < row.length; j++) {
                maze[i][j] = row[j];
                
                if (maze[i][j].equals("S")) {
                    start = new int[]{i, j};
                }
    
                if (maze[i][j].equals("L")) {
                    labor = new int[]{i, j};
                }
            }
        }
        
        int result = bfs(start, "L");
        int result2 = bfs(labor, "E");
        
        if (result == -1 || result2 == -1)
            return -1;
        
        return result + result2;
    }
    
    public int bfs(int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
    
        while(!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int count = queue.peek()[2];
            visited[x][y] = true;
            
            if (maze[x][y].equals(target)) {
                return count;
            }
            
            queue.poll();
        
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && !visited[nx][ny]) {
                    if (!maze[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
        
        return -1;
    }
}
