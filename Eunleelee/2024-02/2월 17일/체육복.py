def solution(n, lost, reserve):
    answer = 0
    lost_s = list(set(lost) - set(reserve))
    reserve_s = list(set(reserve) - set(lost))
    num = len(lost_s)  
    for i in range(len(lost_s)):
        if lost_s[i] - 1 in reserve_s:
            reserve_s.remove(lost_s[i] - 1)
            num -= 1
        elif lost_s[i] + 1 in reserve_s:
            reserve_s.remove(lost_s[i] + 1)
            num -= 1
    answer = n - num
    return answer
