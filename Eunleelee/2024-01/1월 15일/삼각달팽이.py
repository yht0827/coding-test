DIRS = {0: (1, 0), 1: (0, 1), 2: (-1, -1)}


def solution(n):
    triangle_slug = [[0] * i for i in range(1, n+1)]
    r, c, num = -1, 0, 1
    for i in range(n):
        for _ in range(i, n):
            dir_r, dir_c = DIRS[i % 3]
            r, c = r + dir_r, c + dir_c
            triangle_slug[r][c] = num
            num += 1

    return sum(triangle_slug, [])

print(solution(5))