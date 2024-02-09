from collections import deque

def solution(maps):
    def bfs(start, end):
        visit = [[0 for _ in range(R)] for _ in range(C)]

        queue = deque()
        queue.append(start)

        while queue:
            c, r = queue.popleft()

            for i in range(4):
                nc, nr = c + dc[i] , r + dr[i]

                if 0 <= nc < C and 0 <= nr < R and not visit[nc][nr] and maps[nc][nr] != "X":
                    visit[nc][nr] = visit[c][r] + 1
                    queue.append((nc, nr))

        return visit[end[0]][end[1]]

    C = len(maps)
    R = len(maps[0])
    dc = [-1, 1, 0, 0]
    dr = [0, 0, -1, 1]


    for i in range(C):
        for j in range(R):
            if maps[i][j] == "S": start = (i, j)
            elif maps[i][j] == "L": lever = (i, j)
            elif maps[i][j] == "E": end = (i, j)

    distance1 = bfs(start, lever)
    distance2 = bfs(lever, end)

    return distance1 + distance2 if distance1 and distance2 else -1