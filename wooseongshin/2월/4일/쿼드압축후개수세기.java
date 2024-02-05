import java.util.ArrayList;
import java.util.List;

class Solution {
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double)(b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double)(a2*c1 - a1*c2) / (a1*b2 - a2*b1);

        if((x % 1 != 0) || (y % 1 != 0)) {
            return null;
        }
        return new Point((long)x, (long)y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE, minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;

        for(int i = 0; i < line.length; i++) {
            for(int j = i+1; j <line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(intersection != null) {
                    points.add(intersection);
                    maxX = Math.max(maxX, intersection.x);
                    minX = Math.min(minX, intersection.x);
                    maxY = Math.max(maxY, intersection.y);
                    minY = Math.min(minY, intersection.y);
                }
            }
        }

        int xLength = (int)(maxX - minX + 1);
        int yLength = (int)(maxY - minY + 1);

        char[][] map = new char[yLength][xLength];
        for(char[] row : map) {
            java.util.Arrays.fill(row, '.');
        }

        for(Point point : points) {
            int x = (int)(point.x - minX);
            int y = (int)(maxY - point.y);
            map[y][x] = '*';
        }

        String[] answer = new String[map.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}
