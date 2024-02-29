import java.util.*;

class Solution1 {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public int bfs(int[][] maps){
        int n = maps.length; //세로길이 : 행의 수
        int m = maps[0].length; //가로길이 : 열의 수
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        //시작 위치와 거리를 큐에 추가
        queue.offer(new int[]{0,0,1}); //0,0 좌표에서 시작하고 거리는 1.
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            //목적지에 도달했다면 거리 반환
            if(x==n-1 && y==m-1){
                return distance;
            }

            //상하좌우 이동
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                //맵 범위를 벗어나지 않고, 벽이 아니며, 방문하지 않았다면
                if(nx>=0 && ny>=0 && nx<m && ny<n && maps[ny][nx] ==1 && !visited[ny][nx]){
                    visited[ny][nx] = true; //방문처리
                    queue.offer(new int[]{nx,ny, distance + 1}); //다음 위치와 거리를 큐에 추가.

                }
            }
        }

        //목적지에 도달할 수 없으면
        return -1;

    }
}

class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public int bfs(int[][] maps){
        int n = maps[0].length;//가로길이(Column의 수)
        int m = maps.length;//세로길이(Row의 수)
        boolean[][] visited = new boolean[m][n];
        //bfs
        //1. 정점을 queue에 추가.
        //2. queue에서 poll
        //3. poll한 값을 현재값으로 저장하고,인접노드들을 방문.


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1}); //0,0 은 현재 위치. 1은 거리.

        while(!queue.isEmpty()){
            int[] currentNode = queue.poll();
            int x = currentNode[0];
            int y = currentNode[1];
            int distance = currentNode[2];

            if(x==n-1 && y==m-1){
                return distance;
            }

            //방문하지 않고, 벽이아닌경우만 다음로직 수행.
            if(x>=0 && y>=0 && x<n && y<m && !visited[y][x] && maps[y][x]==1){
                    visited[y][x] = true;//방문처리
                    distance++;//거리 1늘리기.
                    for(int i=0; i<4; i++){ //상하좌우로 이동.
                        queue.offer(new int[]{x+dx[i],y+dy[i],distance});
                    }
            }//if1

        }

        return -1;
    }

}
