from itertools import combinations
def is_prime_number(n):
    if n ==0 or n == 1:
        return False
    else:
        for k in range(2, (n//2)+1):
            if n % k == 0:
                return False
        return True
    
def solution(nums):
    combi = list(combinations(nums, 3))
    cnt = 0
    for i in combi:
        if is_prime_number(sum(i)):
            cnt += 1
    return cnt


print(solution([1,2,3,4])) # 1
print(solution([1,2,7,6,4])) # 4
