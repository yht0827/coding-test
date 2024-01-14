import math

# 소수 판별 함수
def is_prime_number(x):
    # 2부터 x의 제곱근까지의 모든 수를 확인하며
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False 
    return True

def solution(nums):
    answer = 0
    sum_list= []

    for i in range(len(nums) - 2):
        for j in range(i + 1, len(nums) - 1):
            for k in range(j + 1, len(nums)):
                sum_list.append(nums[i] + nums[j] + nums[k])
    
    for i in sum_list:
        if is_prime_number(i):
            answer += 1
    return answer

print(solution([1,2,7,6,4]))