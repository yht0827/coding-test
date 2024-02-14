def is_safe(board, row, col):

    for i in range(row):
        if board[i] == col or \
            board[i] - i == col - row or \
            board[i] + i == col + row:
            return False
    return True

def solve_n_queens(board, row, n, answer):
    if row == n:
        answer[0] += 1
        return

    for col in range(n):
        if is_safe(board, row, col):
            board[row] = col
            solve_n_queens(board, row + 1, n, answer)

def solution(n):
    answer = [0]
    board = [-1] * n
    solve_n_queens(board, 0, n, answer)
    return answer[0]
