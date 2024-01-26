def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    n = m - 1
    for i in range(int(len(score)/m)): 
        answer += score[n] * m
        n += m

    return answer