class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];

            int curlen, len = Integer.MAX_VALUE;

            // 왼쪽
            if (!(startY == targetY && startX >= targetX)) {
                curlen = getDistance(startX, startY, targetX * (-1), targetY);
                len = Math.min(len, curlen);
            }

            // 오른쪽
            if (!(startY == targetY && startX <= targetX)) {
                curlen = getDistance(startX, startY, m + (m - targetX), targetY);
                len = Math.min(len, curlen);
            }

            // 위
            if (!(startX == targetX && startY <= targetY)) {
                curlen = getDistance(startX, startY, targetX, n + (n - targetY));
                len = Math.min(len, curlen);
            }

            // 아래
            if (!(startX == targetX && startY >= targetY)) {
                curlen = getDistance(startX, startY, targetX, targetY * (-1));
                len = Math.min(len, curlen);
            }
            answer[i] = len;

        }

        return answer;
    }

    public int getDistance(int sx, int sy, int tx, int ty) {
        return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
    }
}