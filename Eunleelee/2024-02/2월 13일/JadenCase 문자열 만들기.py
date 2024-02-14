def solution(s):
    s_list = s.split(' ')
    answer = ''
    num = 0
    for i in range(len(s_list)):
        s_list[i] = s_list[i].capitalize()
        answer += s_list[i]
        if i != len(s_list) - 1:
            answer += ' '
            
    return answer
