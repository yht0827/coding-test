from collections import deque

def solution(elements):
    total_sum = list()  # 합으로 나올 수 있는 모든 수를 저장
    total_sum.extend(elements)
    stack = deque()

    for i in range(2, len(elements)):
        circle = deque(elements + elements[:i-1])  # 이렇게 하면 모든 합의 경우의 수를 구할 수 있음
        while circle:
            stack.append(circle.popleft())
            if len(stack) == i:
                total_sum.append(sum(stack))
                stack.popleft()
        stack.clear()  # 찌꺼기 수가 남아있을 수 있음을 고려

    total_sum.append(sum(elements))  # 마지막으로 모든 수를 합한 값을 추가
    answer = len(list(set(total_sum)))  # 중복되는 값을 제거 후, 배열의 길이를 구함
            
    return answer

print(solution([7, 9, 1, 1, 4]))