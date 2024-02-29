from collections import deque

def solution(maps):

    dx = [-1,0,1,0]
    dy = [0,1,0,-1]

    result = 0

    n = len(maps)
    m = len(maps[0])

    ck = [[0]*m for _ in range(n)]
    dis = [[0]*m for _ in range(n)]
    queue = deque()

    ck[0][0] = 1
    dis[0][0] = 1
    queue.append((0,0))

    while queue:
        now = queue.popleft()

        for i in range(4):
            x = now[0]+dx[i]
            y = now[1]+dy[i]

            if 0<=x<=n-1 and 0<=y<=m-1:
                if ck[x][y] == 0 and maps[x][y] == 1:
                    ck[x][y] = 1
                    dis[x][y] = dis[now[0]][now[1]] + 1
                    queue.append((x,y))

    result = -1 if dis[n-1][m-1] == 0 else dis[n-1][m-1]

    return result
