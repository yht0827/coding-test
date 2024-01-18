## 문제 접근 방식: 스택 또는 조합
from itertools import permutations
def solution(expression):
    operations = list(permutations(['+', '-', '*'], 3))
    answer = []
    print(operations)

    for op in operations:
        a = op[0]
        b = op[1]
        temp_list = []
        for e in expression.split(a):
            temp = [f"({i})" for i in e.split(b)]
            temp_list.append(f'({b.join(temp)})')
        
        answer.append(abs(eval(a.join(temp_list))))
        print(temp_list)
    return max(answer)

print(solution("100-200*300-500+20")) # 60420
print(solution("50*6-3*2")) # 300
