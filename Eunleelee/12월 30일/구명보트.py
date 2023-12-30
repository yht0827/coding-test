from collections import deque

def solution(people, limit):
    answer = 0
    people.sort(reverse=True) 
    deque_people = deque(people) # 효율성 문제를 따져야 하기 때문에 배열대신 deque를 사용

    while len(deque_people) > 1:
        if deque_people[0] + deque_people[-1] > limit: 
            deque_people.popleft()
            answer += 1
        else:
            deque_people.pop()
            deque_people.popleft()
            answer += 1
    
    if len(deque_people) == 1:
        answer += 1

    return answer