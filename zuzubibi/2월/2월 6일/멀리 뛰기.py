def solution(n):
    if n == 1:
        return 1
    else:
        # DP 테이블 초기화
        dp = [0]*(n+1)
        dp[1] = 1
        dp[2] = 2

        # 점화식 적용, 숫자가 커지는 것을 방지하기 위해
        # 계속해서 나머지 연산자 활용하기
        for i in range(3, n+1):
            dp[i] = (dp[i-1]+dp[i-2])% 1234567
        
        # 테이블의 마지막값 반환
        return dp[-1]
    
def anotherSolution(n):
    dp=[0]*(n+1)
    dp[0]=1
    dp[1]=2

    for i in range(2,n):
        dp[i] = (dp[i-2]+dp[i-1])% 1234567

    return dp[-1]

print(solution(4)) # 5 
print(solution(3)) # 3