from collections import deque

def bfs(start, end, maps):
    dy = [0, 1, -1, 0]
    dx = [1, 0, 0, -1]
    
    n = len(maps)
    m = len(maps[0])
    visited = [[False]*m for _ in range(n)]
    que = deque()
    flag = False
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == start:
                que.append((i, j, 0))
                visited[i][j] = True
                flag = True
                break 
        if flag: break
                
    while que:
        y, x, cost = que.popleft()
        
        if maps[y][x] == end:
            return cost
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0 <= ny < n and 0 <= nx < m and maps[ny][nx] != 'X':
                if not visited[ny][nx]:
                    que.append((ny, nx, cost + 1))
                    visited[ny][nx] = True
                    
    return -1
            
def solution(maps):
    path1 = bfs('S', 'L', maps)
    path2 = bfs('L', 'E', maps)
    
    if path1 != -1 and path2 != -1:
        return path1 + path2
        
    return -1