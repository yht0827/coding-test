def solution(numbers):
    answer = ''
    
    numbers = list(map(str, numbers))               # string으로 바꾸어서 비교
    numbers.sort(key = lambda x : x*3,reverse=True)  # 3번씩 반복하면 붙였을때 큰수 찾기 가능
    
    for i in numbers:             # 정렬된 리스트를 answer에 순서대로 더해줌
        answer += i
    
    return str(int(answer))