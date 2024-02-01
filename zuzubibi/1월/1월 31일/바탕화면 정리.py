def solution(wallpaper):
    x, y = [], []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] =='#':
                x.append(i)
                y.append(j)

    return [min(x), min(y), max(x)+1, max(y)+1]


print(solution([".#...", "..#..", "...#."])) # [0, 1, 3, 4]
print(solution(["..........", ".....#....", "......##..", "...##.....", "....#....."])) # [1, 3, 5, 8]
print(solution([".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."])) # [0, 0, 7, 9]
print(solution(["..", "#."])) # [1, 0, 2, 1]
