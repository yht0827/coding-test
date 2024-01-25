def solution(name, yearning, photo):
    answer = []
    
    for i in photo:
        sum = 0
        for j in i:
            if j in name:
                x = name.index(j)
                sum += yearning[x]
        answer.append(sum)
                
    return answer