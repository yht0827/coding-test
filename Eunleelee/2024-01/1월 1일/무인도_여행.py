from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y, r, c, visited, field):
    q = deque([(x, y)])
    visited[x][y] = 1
    cost = int(field[x][y])

    while q:
        cx, cy = q.popleft()

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if 0 <= nx < r and 0 <= ny < c and field[nx][ny] != 'X':
                if not visited[nx][ny]:
                    visited[nx][ny] = 1
                    cost += int(field[nx][ny])
                    q.append((nx, ny))

    return visited, cost   

def solution(maps):
    answer = []
    r, c = len(maps), len(maps[0])
    visited = [[0]*c for _ in range(r)]

    for i in range(r):
        for j in range(c):
            if maps[i][j] != 'X' and not visited[i][j]:
                visited, ans = bfs(i, j, r, c, visited, maps)
                answer.append(ans)

    return sorted(answer) if answer else [-1]