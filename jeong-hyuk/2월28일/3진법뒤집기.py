def solution(n):
    #n을 3진법으로 변환
    ternary = ''
    while n > 0:
        n, remainder = divmod(n, 3)
        ternary += str(remainder)
    
    #\3진법을 뒤집어서 다시 10진법으로 변환
    answer = int(ternary, 3)
    return answer