def solution(nums):
    # 가능한 폰켓몬의 종류 수
    max_mon = len(nums) // 2
    # 중복을 제거한 폰켓몬 종류 수
    unique_mon = len(set(nums))
    return min(max_mon, unique_mon)