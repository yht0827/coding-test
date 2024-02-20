def solution(n,a,b):
    answer = 0
    person = [i for i in range(1, n+1)]
    person[a-1] = 'A'
    person[b-1] = 'B'
    p = 0; turn = 1
    pp = []
    while 1:
        for i in range(int(len(person)/2)):
            if 'A' in person[p:p+2] and 'B' in person[p:p+2]:
                answer = turn
            elif 'A' in person[p:p+2]:
                pp.append('A')
            elif 'B' in person[p:p+2]:
                pp.append('B')
            else:
                pp.append(i+1)
            p += 2
        if answer != 0:
            break
        turn+=1
        person = pp
        pp = []; p = 0
                

    return answer
