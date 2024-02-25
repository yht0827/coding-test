def solution(people, limit):
    people.sort()  # 사람들의 몸무게를 오름차순으로 정렬
    left = 0  # 가장 가벼운 사람의 인덱스
    right = len(people) - 1  # 가장 무거운 사람의 인덱스
    count = 0  # 보트의 수
    
    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1  # 가장 가벼운 사람과 가장 무거운 사람이 함께 탈출
        right -= 1  # 가장 무거운 사람은 무조건 탈출
        count += 1  # 보트의 수 증가
    
    return count