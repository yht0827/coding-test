def count_one_bits(n):
    # 이진법으로 변환 후 1의 개수 반환
    return bin(n).count('1')

def solution(n):
    answer = n + 1
    
    # 주어진 숫자의 이진법 표현에서 1의 개수와 같은 수 중에서 가장 작은 수 찾기
    while count_one_bits(answer) != count_one_bits(n):
        answer += 1
    
    return answer