def solution(s):
    answer = ''
    s_list = s.split(' ')
    for i in range(len(s_list)):
        s_list[i] = int(s_list[i])
    max = s_list[0]
    min = s_list[0]
    for i in range(len(s_list)-1):
        if s_list[i] >= s_list[i+1] and s_list[i] >= max:
            max = s_list[i]
        elif s_list[i+1] >= s_list[i] and s_list[i+1] >= max:
            max = s_list[i+1]
        if s_list[i] <= s_list[i+1] and s_list[i] <= min:
            min = s_list[i]
        elif s_list[i+1] <= s_list[i] and s_list[i+1] <= min:
            min = s_list[i+1]
    answer = '{} {}'.format(min, max)
    return answer
