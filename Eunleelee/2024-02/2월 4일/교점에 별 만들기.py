def solution(line):
    INF = float('inf')
    mark,L = [], len(line)
    minx, maxx, miny, maxy = INF, -INF, INF, -INF
    for i in range(L):
        for j in range(i, L):
            if i==j : continue
            A, B, E, C, D, F = * line[i], *line[j]
            mo = A * D - B * C
            if mo == 0: continue
            x, y = (B * F - E * D) / mo, (E * C - A * F) / mo
            if x - int(x) or y - int(y) : continue
            x, y = int(x), int(y)
            minx, maxx, miny, maxy = min(minx, x), max(maxx, x),min(miny, y),max(maxy, y)
            mark.append((x, y))
    res=[['.' for _ in range(maxx - minx + 1)] for _ in range(maxy - miny + 1)]
    for x, y in mark : res[maxy - y][x - minx] = '*'
    return [''.join(s) for s in res]