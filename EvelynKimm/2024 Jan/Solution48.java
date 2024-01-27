import java.util.*;

class Solution48 {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    boolean[][] visited;
    public int solution(String[] board) {
        int answer = 0;
        int sr = 0, sc = 0, er = 0, ec = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                if(board[i].charAt(j)=='R'){
                    sr = i;
                    sc = j;
                }
                else if(board[i].charAt(j)=='G'){
                    er = i;
                    ec = j;
                }
            }
        }
        visited = new boolean[board.length][board[0].length()];

        answer = bfs(sr, sc, er, ec, board);

        return answer;
    }

    public int bfs(int sr, int sc, int er, int ec, String[] board){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            int[] p = q.poll();
            int cnt = p[2];

            if(p[0]==er && p[1]==ec){
                return cnt;
            }


            for(int i=0; i<4; i++){
                int d = i;
                int r = p[0];
                int c = p[1];
                while(true){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr>=board.length || nr<0 || nc<0 || nc>=board[0].length() || board[nr].charAt(nc)=='D'){
                        break;
                    }
                    r = nr;
                    c = nc;
                }

                if(r==p[0] && c==p[1]) continue;
                if(visited[r][c]){
                    continue;
                }
                else {
                    q.add(new int[]{r, c, cnt+1});
                    visited[r][c] = true;
                }
            }

        }

        return -1;
    }
}