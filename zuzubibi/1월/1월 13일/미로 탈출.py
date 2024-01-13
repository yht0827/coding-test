# BFS
from collections import deque
def bfs(start, end, maps):
    #탐색 방향
    dx= [0,1,0,-1]
    dy= [1,0,-1,0]

    n = len(maps) # 세로
    m = len(maps[0]) #가로
    visited = [[False]*m for _ in range(n)]
    que = deque()
    flag = False

    # 초기값 설정
    for i in range(n):
        for j in range(m):
            # 출발하고자 하는 좌표 기록
            if maps[i][j] == start:
                que.append((i,j,0))
                # 별도의 cost 리스트를 만들지 않고 que에 바로 기록(0)
                visited[i][j] = True
                flag=True; break
        # 시작 지점은 한 개만 존재하기 때문에 찾으면 바로 나옴
        if flag: break
    
    # BFS 시작
    while que:
        y,x,cost = que.popleft()

        if maps[y][x] == end:
            return cost
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            # maps 범위내에서 벽이 아니라면 지나갈 수 있음
            if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] !='X':
                if not visited[ny][nx]: # 아직 방문하지 않은 통로라면
                    que.append((ny, nx, cost+1))
                    visited[ny][nx] = True
    return -1 #탈출 할 수 없다면 
    
            
    return
def solution(maps):
    path1 = bfs('S', 'L', maps) # 시작 지점 -> 레버
    path2 = bfs('L', 'E', maps) # 시작 지점 -> 출구

    # 둘다 -1이 아니라면 탈출가능
    if path1 != -1 and path2 != -1:
        return path1 + path2
    # 둘 중 하나라도 -1이면 탈출할 수 없음
    return  -1



print(solution(["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"])) #16
print(solution(["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"])) #-1