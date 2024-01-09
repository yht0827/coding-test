def solution(x):
    zero_num = 0
    count = 0
    
    while x != '1':
        zero_num += x.count('0')
        x = x.replace('0', '')
        x = format(len(x), 'b')
        count += 1
    
    answer = [count, zero_num]
    return answer

print(solution("01110"))