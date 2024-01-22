def solution(n):
    answer = 0
    num = 0
    for i in range(1, n):
        if n % i == 1 and num == 0:
            answer = i
            num = 1
    return answer