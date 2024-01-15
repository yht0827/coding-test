def solution(nums):
    nums = list(map(str, nums))
    nums.sort(key=lambda x : x* 3, reverse=True)
    return str(int(''.join(nums)))

print(solution([6, 10, 2])) # '6210'
print(solution([3, 30, 34, 5, 9])) # "9534330"