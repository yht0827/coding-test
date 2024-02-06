def solution(nums):
    l = len(nums)//2
    re = len(set(nums))
    # print(set(nums), l)
    return l if re > l else re

def anotherSolution(nums):
    return min(len(nums)/2, len(set(nums)))

print(solution([3,1,2,3])) # 2
print(solution([3,3,3,2,2,4])) # 3
print(solution([3,3,3,2,2,2])) # 2