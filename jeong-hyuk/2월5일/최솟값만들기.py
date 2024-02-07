def solution(A, B):
    # A를 오름차순, B를 내림차순으로 정렬
    A.sort()
    B.sort(reverse=True)
    
    # 각 배열의 요소를 곱하여 더하기
    answer = sum(a * b for a, b in zip(A, B))
    
    return answer