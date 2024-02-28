def solution(priorities, location):
    queue = [(i, q) for i,q in enumerate(priorities)]
    answer = 0

    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer +=1
            if cur[0] == location:
                return answer
            
def sol(pri, loc):
    queue = [(i,q) for i,q in enumerate(pri)]
    answer = 0

    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == loc:
                return answer
            
def sol(pri, loc):
    queue = [(i,p) for i,p in enumerate(pri)]
    answer = 0

    while True:
        cur = queue.pop(0)
        if any(cur[1] < q[1] for q in queue):
            queue.append(cur)
        else:
            answer += 1
            if cur[0] == loc:
                return answer
            
print(solution([2, 1, 3, 2], 2)) # 1
print(solution([1,1,9,1,1,1], 0)) # 5