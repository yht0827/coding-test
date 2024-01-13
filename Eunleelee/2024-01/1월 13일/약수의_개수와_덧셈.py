def solution(left, right):
    answer = 0
    for i in range(left, right + 1):
        sum = 0
        for j in range(1, i+1):
            if i % j == 0:
                sum += 1
        if sum % 2 == 0:
            answer += i
        else:
            answer -= i
    return answer