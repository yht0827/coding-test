# 참고 자료: https://aiday.tistory.com/116
#-------------------------------------------------------
# 첫번째 해결 법: 문제가 있다. 작은 수는 가능하지만 수가 많아지만 문제 발생
from itertools import combinations
def solution(number, k):
    result = 0
    for i in list(combinations(number, len(number)-k)):
        result = max(result, int(''.join(i)))
    return str(result)


def anotherSolution(number, k):
    stack =  []

    # number의 길이만큼 for loop
    for num in number:
        # 1.  제거할 수 k가 남았고
        # 2. 스택에 값이 있고
        # 3. 스택의 마지막 값이 num보다 작다면
        # 제거 후 제거할 수 k를 1씩 감소
        while k > 0  and stack and stack[-1] < num:
            stack.pop()
            k -= 1
        
        # 스택에 num 추가
        stack.append(num)

    # k가 남아있을 경우 - testcase number: "93939", k:2, 출력: 999, 정답: 99
    if k != 0:
        stack = stack[:-k]
    
    # 배열을 문자열로 바꿔주고 반환
    return ''.join(stack)


print(anotherSolution("1924",2)) # "94"
print(anotherSolution("1231234", 3)) # "3234"
print(anotherSolution("4177252841", 4)) # "775841"
