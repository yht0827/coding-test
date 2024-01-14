# 약수의 수 구하기
def measure(n):
    return sum(1 for i in range(1, n+1) if n%i==0)


# 약수가 짝수면 더하고, 홀수개이면 뺌
def solution(l,r):
    return sum(i if measure(i)%2 ==0 else -i for i in range(l, r+1))
 
print(solution(13,17)) # 43
print(solution(24, 27)) # 52