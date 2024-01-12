def solution(lottos, win_nums):
    answer = [0, 0]
    score = 0
    zero_score = 0
    for i in range(len(lottos)):
        if lottos[i] == 0:
            zero_score += 1
        elif lottos[i] in win_nums:
            score += 1
            win_nums.remove(lottos[i])
    
    if score == 6:
        answer[1] = 1
    elif score == 5:
        answer[1] = 2
    elif score == 4:
        answer[1] = 3
    elif score == 3:
        answer[1] = 4
    elif score == 2:
        answer[1] = 5
    else:
        answer[1] = 6
    
    score = zero_score + score 
    if score == 6:
        answer[0] = 1
    elif score == 5:
        answer[0] = 2
    elif score == 4:
        answer[0] = 3
    elif score == 3:
        answer[0] = 4
    elif score == 2:
        answer[0] = 5
    else:
        answer[0] = 6
    
    return answer