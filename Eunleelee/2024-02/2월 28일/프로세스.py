def solution(priorities, location):
    answer = 0; n = max(priorities)
    i = 0
    an = 0
    while 1:
        if priorities[i] < n:
            priorities.append(priorities[i])
            priorities[i] = 0
            if i == location:
                location = len(priorities)-1
        elif priorities[i] >= n:
            priorities[i] = 0
            answer += 1
            n = max(priorities)
            if i == location:
                an = -1
        if an == -1:
            break
        i += 1

            
    return answer
