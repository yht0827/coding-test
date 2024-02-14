# back tracking 문제 - DFS 문제
def adjacent(x): # x와 i가 같으면 행이 같은거
    for i in range(x):
        # 열이 같거나 대각선에 위치라면 false
        if row[x] == row[i] or abs(row[x]-row[i]) == x-i:
            return False
    return True

def dfs(x):
    global result

    if x == N:
        result += 1
    else:
        # 각 행에 퀸 놓아보기
        for i in range(N):
            row[x] = i
            # 행, 열 대각선 체크 true 반환시 다음 줄 체크
            # 백트래킹
            if adjacent(x):
                dfs(x+1)



N = int(input())
row = [0] * N
result = 0

dfs(0)
print(result)