def solution(priorities, location):
    answer = 0
    
    while True:
        front_doc = priorities.pop(0)
        location -= 1
        
        if any(front_doc < priority for priority in priorities):
            #우선순위가 더 높은 문서가 있다면, 맨 뒤로 이동
            priorities.append(front_doc)
            if location < 0:
                location = len(priorities) - 1
        else:
            #우선순위가 가장 높은 문서라면 출력
            answer += 1
            if location == -1:
                break
    
    return answer