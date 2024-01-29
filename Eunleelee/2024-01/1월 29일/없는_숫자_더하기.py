def solution(numbers):
    answer = 0
    numbers.sort()
    for i in range(10):
        if i not in numbers:
            answer += i
    return answer