import java.util.Stack;

class Solution11 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i=0; i< moves.length; i++) {
            for (int j=0; j< board.length; j++) {
                if (board[j][moves[i]-1] != 0) {
                    if (stack.peek() == board[j][moves[i]-1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}