def solution(x, n):
    answer = list(map(lambda i: x * i, range(1, n+1)))
    return answer
