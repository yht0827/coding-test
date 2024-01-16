def solution(n, m, section):
    done = 0
    answer = 0

    for i in range(len(section)):
        if done == 0:
            done += 1

        elif done + (section[i] - section[i-1]) <= m:
            done += section[i] - section[i-1]
        
        else:
            answer += 1
            done = 1

    if done != 0:
        answer += 1

    return answer

print(solution(8, 4, [2, 3, 6]))