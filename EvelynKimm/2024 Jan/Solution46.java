class Solution46 {
    static int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int plus = 0;

        matrix = new int[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                plus ++;
                matrix[i][j] = plus;
            }
        }

        for(int i=0; i<queries.length; i++) {
            answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        return answer;
    }

    static int rotate(int x1, int y1, int x2, int y2) {
        x1--;
        y1--;
        x2--;
        y2--;

        int temp = matrix[x1][y1];
        int min = temp;

        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            min = Math.min(min, matrix[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            matrix[x2][i] = matrix[x2][i + 1];
            min = Math.min(min, matrix[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            min = Math.min(min, matrix[i][y2]);
        }
        for (int i = y2; i > y1; i--) {
            matrix[x1][i] = matrix[x1][i - 1];
            min = Math.min(min, matrix[x1][i]);
        }
        matrix[x1][y1 + 1] = temp;
        return min;
    }
}
