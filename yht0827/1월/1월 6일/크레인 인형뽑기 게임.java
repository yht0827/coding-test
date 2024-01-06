import java.util.Stack;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {

					if (!basket.isEmpty()) {
						if (basket.peek() == board[j][moves[i] - 1]) {
							basket.pop();
							board[j][moves[i] - 1] = 0;
							answer += 2;
							break;
						}
					}

					basket.push(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}

		return answer;
	}
}