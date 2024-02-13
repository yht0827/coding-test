def solution(x):
    st = sum([int(i) for i in str(x)])
    if x % st ==0:
        return True
    return False


print(solution(10)) # true
print(solution(12))# true
print(solution(11))# false
print(solution(13))# false