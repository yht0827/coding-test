def solution(people, limit):
    people.sort()
    cnt = 0
    front, end = 0, len(people)-1

    while front <= end:
        if people[front] + people[end] <= limit:
            front += 1
        
        end -= 1
        cnt += 1

    return cnt

print(solution([70, 50, 80, 50], 100)) # 3
print(solution([70, 80, 50], 100)) # 3