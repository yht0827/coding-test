from collections import deque

def solution(board):
    dr,dc = [0, 0, -1, 1], [-1, 1, 0, 0]# 4방향
    lenR,lenC = len(board), len(board[0])# 세로, 가로 길이
    start = [-1, -1] # 시작점
    visit = [list(False for _ in range(lenC)) for _ in range(lenR)] # 방문여부

    # 시작점 찾기
    for i in range(lenR):
        for j in range(lenC):
            if board[i][j] == 'R':
                start = [i, j]
                break;
        if start[0] != -1:break;

    # 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동
    def move(r,c,dir):
        while True:
            r += dr[dir]
            c += dc[dir]
            if r<0 or r>=lenR or c<0 or c>=lenC : # 지도를 벗어남
                break
            elif board[r][c] == 'D': # 장애물을 만남
                break
        # 현재 좌표가 지도를 벗어나거나 장애물을 만난 위치 -> 한칸 물러나기
        r -= dr[dir]
        c -= dc[dir]
        return [r, c]

    q = deque()
    q.appendleft([start[0], start[1], 0])# 좌표, distance
    while q:
        r,c,dis = q.pop()
        for i in range(4):
            nR,nC = move(r,c,i)
            # 이미 온 길인가?
            if visit[nR][nC] :
                continue
            # 목적지인가?
            elif board[nR][nC] == 'G':
                return dis + 1
            # 단순 이동
            else :
                visit[nR][nC] = True
                q.appendleft([nR,nC,dis+1])

    return -1