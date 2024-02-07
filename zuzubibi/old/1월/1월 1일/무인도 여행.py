# 이 문제는 내가 제일 약한 문제..
# 문제 핵심: BFS, DFS


from collections import deque

def bfs(maps, i,j,n,m, visit):
    dx, dy = [0,0,-1,1], [-1,1,0,0]
    queue = deque()
    queue.append((i,j))

    visit[i][j] = 1

    area = int(maps[i][j])
    while queue:
        x,y = queue.popleft()
        
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if 0 <=nx<n and 0 <= ny < m and visit[nx][ny] != 1 and maps[nx][ny] != 'X':
                visit[nx][ny] = 1
                area += int(maps[nx][ny])
                queue.append((nx, ny))
    return area

def solution(maps):
    n,m = len(maps), len(maps[0])
    visit = [[0]* m for _ in range(n)]
    answer = []

    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and visit[i][j] == 0:
                answer.append(bfs(maps, i,j,n,m, visit))
    if answer:
        return sorted(answer)
    else:
        return [-1]
    

def dfs(maps, i, j, n, m, visit):
    visit[i][j] = True
    area = int(maps[i][j])
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    for dx, dy in directions:
        x, y = i + dx, j + dy
        if 0 <= x < n and 0 <= y < m and not visit[x][y] and maps[x][y] != 'X':
            area += dfs(maps, x, y, n, m, visit)

    return area

def solution2(maps):
    answer = []
    n, m = len(maps), len(maps[0])
    visit = [[False] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and not visit[i][j]:
                answer.append(dfs(maps, i, j, n, m, visit))

    if answer:
        return sorted(answer)
    else:
        return [-1]
    

print(solution(["X591X","X1X5X","X231X", "1XXX1"])) # [1, 1, 27]
print(solution2(["X591X","X1X5X","X231X", "1XXX1"])) # [1, 1, 27]