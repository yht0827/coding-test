def solution(s):
    stack = []

    for char in s:
        if stack and stack[-1] == char:
            stack.pop()  # 스택의 가장 위의 문자와 현재 문자가 같으면 제거
        else:
            stack.append(char)  # 아니라면 스택에 추가

    if not stack:  # 모든 문자를 제거했다면 1 반환
        return 1
    else:
        return 0
