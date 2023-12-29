def solution(x,y,n):
    answer = 0
    queue = []
    queue.append([y,0])

    while len(queue) > 0:
        now = queue.pop(0)
        if now[0] == x:
            return now[1]
        if now[0] > 0:
            if now[0] % 2 == 0:
                queue.append([now[0]//2,  now[1]+1])
            if now[0] % 3 == 0:
                queue.append([now[0]//3, now[1]+1])
            queue.append([now[0]-n, now[1]-1])
    return answer



print(solution(10,40,5))     # 2
# print(solution(10,40,30))    # 1
# print(solution(2,5,4))       # -1
