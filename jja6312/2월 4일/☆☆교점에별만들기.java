import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<Pair> points = new HashSet<>();
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0], B = line[i][1], E = line[i][2];
                long C = line[j][0], D = line[j][1], F = line[j][2];

                long denominator = A * D - B * C;

                if (denominator == 0)
                    continue; // 평행하거나 일치

                long xNumerator = B * F - E * D;
                long yNumerator = E * C - A * F;

                if (xNumerator % denominator != 0 || yNumerator % denominator != 0)
                    continue; // 정수 교점이 아님

                long x = xNumerator / denominator;
                long y = yNumerator / denominator;

                points.add(new Pair(x, y));

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        char[][] map = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
        for (char[] row : map) {
            Arrays.fill(row, '.');
        }

        for (Pair point : points) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            map[y][x] = '*';
        }

        String[] answer = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }

    class Pair {
        long x, y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
