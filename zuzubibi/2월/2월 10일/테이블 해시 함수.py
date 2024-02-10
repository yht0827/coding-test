def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(key = lambda x: [x[col-1], -x[0]])
    for i in range(row_begin, row_end+1):
        result = 0
        for j in data[i-1]:
            result += j%i
        answer = answer ^ result
    return answer


print(solution([[2,2,6],[1,5,10],[4,2,9],[3,8,3]],2,2,3)) # 4