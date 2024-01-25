class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int firstCheckH = h-1;
        int LastCheckH = h+1;
        
        int firstCheckW = w-1;
        int LastCheckW = w+1;
        
        if(firstCheckH >= 0 && board[h][w].equals(board[firstCheckH][w]))
            answer++;
        if(LastCheckH < board.length && board[h][w].equals(board[LastCheckH][w]))
            answer++;
        if(firstCheckW >= 0 && board[h][w].equals(board[h][firstCheckW]))
            answer++;
        if(LastCheckW < board.length && board[h][w].equals(board[h][LastCheckW]))
            answer++;
           
        
        return answer;
    }
}
