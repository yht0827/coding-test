from collections import deque
def solution(rows, columns, queries):
    # 행렬 초기화
    answer = []
    board = []
    for y in range(rows):
        b = []
        for x in range(columns):
            b.append((y*columns) + (x+1))
        board.append(b)

    # 회전
    for y1, x1, y2, x2 in queries:
        y1, x1, y2, x2 = y1-1, x1-1, y2-1, x2-1
        tmp = deque()

        for y in range(y1, y2):
            tmp.append(board[y][x1])
        for x in range(x1,x2):
            tmp.append(board[y2][x])
        for y in range(y2, y1, -1):
            tmp.append(board[y][x2])
        for x in range(x2, x1, -1):
            tmp.append(board[y1][x])
        
        tmp.append(tmp.popleft())
        answer.append(min(tmp))
        
        for y in range(y1, y2):
            board[y][x1] = tmp.popleft()
        for x in range(x1,x2):
            board[y2][x] = tmp.popleft()
        for y in range(y2, y1,-1):
            board[y][x2] = tmp.popleft()
        for x in range(x2, x1, -1):
            board[y1][x] = tmp.popleft()
    return answer



print(solution(6,6,[[2,2,5,4],[3,3,6,6],[5,1,6,3]])) # [8, 10, 25]
print(solution(3,3,[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]])) # [1, 1, 5, 3]
print(solution(100,97,[[1,1,100,97]])) #[1]