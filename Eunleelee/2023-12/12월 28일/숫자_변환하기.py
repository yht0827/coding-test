# 0 ~ y + 1 까지의 inf 값을 가지는 배열을 만듦
# x 부터 '+n', '*2', '*3'을 모두 계산해서 계산한 값을 위치로 해서 배열에 저장
# 계산한 값의 위치에 해당하는 값과 현재 위치의 값에 +1을 한 것 중 작은 수를 저장
# x+n, x*2, x*3가 되지 않는 값 즉, inf 값을 가진 곳은 건너뜀
# 배열에 y에 위치하는 곳에 inf가 아닌 값이 있다면 그 값을 반환
# inf 값이 있다면 -1을 반환

def solution(x, y, n):
    if x == y:
        return 0

    dp = [float('inf')] * (y + 1)
    dp[x] = 0

    for i in range(x, y + 1):
        if dp[i] == float('inf'):
            continue

        if i + n <= y:
            dp[i + n] = min(dp[i + n], dp[i] + 1)

        if i * 2 <= y:
            dp[i * 2] = min(dp[i * 2], dp[i] + 1)

        if i * 3 <= y:
            dp[i * 3] = min(dp[i * 3], dp[i] + 1)

    if dp[y] == float('inf'):
        return -1

    return dp[y]
    
print(solution(10, 40, 30))