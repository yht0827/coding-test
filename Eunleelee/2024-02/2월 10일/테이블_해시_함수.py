def solution(data, col, row_begin, row_end):
    answer = -1
    data = sorted(data, key = lambda x:(x[col-1], -x[0]))
    
    for i in range(row_begin-1, row_end):
        n = 0
        for j in range(len(data[0])):
            n += data[i][j] % (i+1)
        
        if answer == -1:
            answer = n
        else:
            answer = answer ^ n
        
    return answer