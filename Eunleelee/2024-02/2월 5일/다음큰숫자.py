def solution(n):
    answer = 0
    number = n+1
    n_binary = format(n, 'b')
    list_n_binary = list(n_binary)
    one_num = list_n_binary.count("1")
    while 1:
        number_binary = format(number, 'b')
        one_number = list(number_binary).count("1")
        if one_num == one_number:
            answer = number
            break
        number += 1
    return answer