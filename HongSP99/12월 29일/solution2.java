import java.math.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};


    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        boolean[][] map = new boolean[h][w];

        int y = 0;
        int x = 0;
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                String c = park[i].charAt(j)+"";
                if(c.equals("S")) {
                    y = i;
                    x = j;
                }
                map[i][j] = !c.equals("X");
            }
        }

        for(String route: routes) {
            String tokens[] = route.split(" ");
            int dir = getDir(tokens[0]);
            int dis = Integer.parseInt(tokens[1]);

            int nx = x + dx[dir]*dis;
            int ny = y + dy[dir]*dis;

            if(nx>=0 && nx<w && ny>=0 && ny<h) {
                boolean road = true;
                for(int i=Math.min(y, ny);i<=Math.max(y, ny);i++) if(!map[i][x]) road = false;
                for(int i=Math.min(x, nx);i<=Math.max(x, nx);i++) if(!map[y][i]) road = false;

                if(road) {
                    x = nx;
                    y = ny;
                }
            }
        }

        int[] answer = {y, x};
        return answer;
    }

    private int getDir(String s) {
        if(s.equals("E")) return 0;
        if(s.equals("W")) return 1;
        if(s.equals("S")) return 2;
        if(s.equals("N")) return 3;
        return -1;
    }
}
