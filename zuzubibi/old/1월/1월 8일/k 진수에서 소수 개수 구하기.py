import math
def is_prime_number(x):
    if x <2:
        return False
    for i in range(2, int(math.sqrt(x))+1):
        if x % i ==0:
            return False
    return True

def solution(n, k):
    result = 0
    jinsu = ''
    while n > 0:
        n, mod = divmod(n,k)
        jinsu += str(mod)
    jinsu = jinsu[::-1]

    jinsu = jinsu.split('0')

    for i in jinsu:
        if i and is_prime_number(int(i)):
            result += 1

    return result



print(solution(437674,3)) # 3
print(solution(110011, 10)) # 2