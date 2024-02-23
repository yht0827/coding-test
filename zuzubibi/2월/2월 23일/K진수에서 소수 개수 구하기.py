def change(n,q):
    rev_base = ''

    while n >0:
        n,mode = divmod(n,q)
        rev_base += str(mode)
    return rev_base[::-1]
import math
def isprime(n):
    if n <= 1: return False
    i = 2
    while i*i <=n:
        if n%i == 0: return False
        i += 1
    return True

def solution(n,k):
    s = change(n,k)
    cnt = 0
    for num in s.split('0'):
        if not num: continue # 빈 문자열에 대한 예외처리
        if isprime(int(num)): cnt += 1
    return cnt


print(solution(437674, 3)) # 3
print(solution(110011, 10)) # 2