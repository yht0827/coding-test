def solution(numbers):
    # numbers의 길이만큼 값 -1을 담은 배열
    answer = [-1] * len(numbers)
    stack = []

    for index, value in enumerate(numbers):
        # 배열 stack에 값이 존재하고 numbers[stack[-1]] 값이 현재 비교하는 값보다 작으면
        while stack and numbers[stack[-1]] < value:
            # stack.pop이 되는 값을 인덱스로 answer에 현재 값을 저장
            answer[stack.pop()] = value

        stack.append(index)

    return answer

print(solution([9, 1, 5, 3, 6, 2]))