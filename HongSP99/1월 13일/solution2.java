import java.util.*;

class Solution {
    int n;
    int m ;
    int[][] deltas = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int solution(String[] maps) {

        int ix = -1;
        int iy = -1;



        n = maps.length;
        m = maps[0].length();

        for(int i =0; i < n; i++){
            for(int j =0; j<m ;j++){

                if(maps[i].charAt(j) == 'S'){
                    ix = i;
                    iy = j;
                }
            }
        }

        int[] toLever = bfs(maps,'L', ix, iy);

        if(toLever == null)
            return -1;

        System.out.println(Arrays.toString(toLever));
        int[] toGoal = bfs(maps,'E', toLever[1],toLever[2]);
            System.out.println(Arrays.toString(toGoal));
        if(toGoal == null)
            return -1;

        return toLever[0] + toGoal[0];
    }


    private int[] bfs(String[] maps, char to, int ix, int iy ){
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[] {0,ix, iy});
        while(!q.isEmpty()){
            int[] cur = q.poll();

            int depth = cur[0];
            int x = cur[1];
            int y = cur[2];

            char cs = maps[x].charAt(y);
            if( cs == to){
                return cur;
            }

            for(int[] delta : deltas){
                int nx = delta[0] + x;
                int ny = delta[1] + y;

                if(visitable(visited, nx, ny)){
                    if(maps[nx].charAt(ny) != 'X'){
                        visited[nx][ny] = true;
                        q.add(new int[]{ depth+1 ,nx,ny});
                    }
                }
            }
        }
        return null;
    }
    private boolean visitable(boolean[][] visited, int x, int y){
        if(x<0  || x>=n)
            return false;
        if(y<0 || y>= m)
            return false;
        if(visited[x][y])
            return false;
        return true;
    }
}
