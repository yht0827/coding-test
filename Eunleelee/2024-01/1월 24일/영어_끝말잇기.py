def solution(n, x):
    answer = [0, 0]
    person = 1
    turn = 1
    dogil =''
    prev_word = x[0][0]
    for i in range(len(x)):
        if prev_word != x[i][0] and answer[0] == 0:
            answer[0] = person
            answer[1] = turn
        if x.index(x[i]) != i and answer[0] == 0:
            answer[0] = person
            answer[1] = turn
        prev_word = x[i][-1]
        person+=1
        if person == n+1:
            person = 1
            turn += 1
        
    return answer