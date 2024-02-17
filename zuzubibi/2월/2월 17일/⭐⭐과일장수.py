def solution(k, m, score):
    score.sort(reverse=True)
    answer =0

    for i in range(0, len(score), m):
        tmp = score[i:i+m]

        if len(tmp) == m:
            answer += min(tmp)*m

    return answer


print(solution(3,4,[1, 2, 3, 1, 2, 3, 1])) # 8
print(solution(4,3,	[4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2])) # 33