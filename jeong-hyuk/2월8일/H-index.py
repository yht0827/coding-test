def solution(citations):
    citations.sort(reverse=True)  # 논문 인용 횟수를 내림차순으로 정렬
    
    h_index = 0
    for i, citation in enumerate(citations):
        # 현재 논문 인용 횟수가 현재 인덱스보다 크거나 같으면 h_index를 갱신
        if citation >= i + 1:
            h_index = i + 1
        else:
            break  # 현재 논문 인용 횟수가 현재 인덱스보다 작으면 반복문 종료
            
    return h_index