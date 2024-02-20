def solution(brown, yellow):
    answer = []
    #result_br_garo = yellow + 2
    #result_br_sero = yellow
    ye_num = []
    num = 0
    for i in range(1, yellow + 1):
        if yellow % i == 0:
            ye_num.append(i)

    i=0
    while 1:
        br_garo = ye_num[i] + 2
        br_sero = int(yellow/ye_num[i]) + 2
        br_total = br_garo * 2 + br_sero * 2 - 4
        if br_total == brown and br_garo >= br_sero:
            answer = [br_garo, br_sero]
            break
        i+= 1
    return answer
