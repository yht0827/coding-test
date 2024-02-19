def solution(n):
    answer = 0

    for i in range(1,n+1):
        sum_val = 0
        for j in range(i,n+1):
            sum_val += j
            if sum_val == n:
                answer += 1
            elif sum_val > n:
                break

    return answer 

def anotherSolution(n):
    answer = 0

    for i in range(1, n+1):
        sum_val = 0
        for j in range(i, n+1):
            sum_val += j
            if sum_val == n:
                answer += 1
            elif sum_val > n:
                break
    return answer

def anotherSolution2(n):
    return len([i for i in range(1, n+1, 2) if n % i is 0])

print(anotherSolution(15)) # 4