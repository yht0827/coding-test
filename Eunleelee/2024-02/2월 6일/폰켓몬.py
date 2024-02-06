def solution(nums):
    answer = 0
    a = len(nums) / 2 #가져갈 수 있는 포켓몬의 수
    num = set(nums) # 중복제거
    
    if len(num) < a:
        answer = len(num)
    else:
        answer = a
    
    return answer