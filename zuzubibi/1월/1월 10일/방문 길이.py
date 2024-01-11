def solution(dirs):
    x,y = 0,0
    result = set()
    # L, R, U, D의 이동방향
    dx = [-1,1,0,0]
    dy = [0,0,1,-1]
    move_type = ['L', 'R', 'U', 'D']
    
    for dir in dirs:
        for i in range(len(move_type)):
            if move_type[i] == dir:
                nx = x + dx[i]
                ny = y + dy[i]

        if nx <-5 or nx > 5 or ny <-5 or ny >5:
            continue
        
        result.add(((x,y),(nx, ny)))
        result.add(((nx, ny), (x,y)))
        x, y = nx, ny
    return len(result) // 2
#--------------------------------------------------------
def anotherSolution(dirs):
    s = set()
    x,y = 0,0
    d = {'U': (0,1), 'D':(0,-1), 'R': (1,0), 'L': (-1,0)}
    for i in dirs:
        nx, ny = x + d[i][0], y + d[i][1]
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            s.add((x,y, nx,ny))
            s.add((nx,ny, x,y))
            x,y = nx,ny
    return len(s)//2

print(anotherSolution("ULURRDLLU")) # 7
print(anotherSolution("LULLLLLLU")) # 7