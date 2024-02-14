def solution(n):
    n_list = list(map(int, str(n)))
    answer = True
    sum = 0
    for i in range(len(n_list)):
        sum += n_list[i]
    if n%sum != 0:
        answer = False
    return answer