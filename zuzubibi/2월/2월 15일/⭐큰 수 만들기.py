# 참고 자료: https://aiday.tistory.com/116
#-------------------------------------------------------
# 첫번째 해결 법: 문제가 있다. 작은 수는 가능하지만 수가 많아지만 문제 발생
from itertools import combinations
def solution(number, k):
    result = 0
    for i in list(combinations(number, len(number)-k)):
        result = max(result, int(''.join(i)))
    return str(result)




print(solution("1924",2)) # "94"
print(solution("1231234", 3)) # "3234"
print(solution("4177252841", 4)) # "775841"
