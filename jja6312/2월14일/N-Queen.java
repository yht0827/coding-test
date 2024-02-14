class Solution {
    int size;
    int cnt;

    public int solution(int n) {
        int answer = 0;

        // 깊이 우선 탐색을 써야겠다.
        size = n;
        cnt = 0;
        int[] board = new int[n];
        placeQueens(board, 0);
        answer = cnt;

        return answer;
    }

    private void placeQueens(int[] board, int row) {
        if (row == size) {
            cnt++;
        }
        for (int col = 0; col < size; col++) {
            if (isSafety(board, row, col)) {
                board[row] = col;
                placeQueens(board, row + 1);
            }
        }
    }

    private boolean isSafety(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(row - i) == Math.abs(col - board[i])) {
                return false;
            }
        }
        return true;
    }
}