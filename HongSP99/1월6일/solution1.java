import java.util.Stack;
import java.util.Arrays;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int[] order = new int[board[0].length];

        Arrays.fill(order, -1);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != 0 && order[j] == -1)
                    order[j] = i;
            }
        }
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<moves.length; i++){
            if(order[moves[i]-1] == board[0].length) continue;
            int temp = board[order[moves[i]-1]][moves[i]-1];
            board[order[moves[i]-1]][moves[i]-1] = 0;
            order[moves[i]-1]++;

            if(stack.isEmpty()) stack.push(temp);
            else if(stack.peek() == temp) {
                stack.pop();
                count += 2;
            } else{
                stack.push(temp);
            }
        }
        return count;
    }
}
