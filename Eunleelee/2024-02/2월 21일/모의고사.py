def solution(answers):
    result = []
    a = [1, 2, 3, 4, 5]
    b = [2, 1, 2, 3, 2, 4, 2, 5]
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    a_num = 0; b_num = 0; c_num = 0
    o = [0, 0, 0]
    for answer in answers:
        if answer == a[a_num]:
            o[0] += 1
        if answer == b[b_num]:
            o[1] += 1
        if answer == c[c_num]:
            o[2] += 1
        a_num += 1; b_num += 1; c_num += 1
        if len(a) == a_num:
            a_num = 0
        if len(b) == b_num:
            b_num = 0
        if len(c) == c_num:
            c_num = 0
    
    m = max(o)
    
    if o[0] == m:
        result.append(1)
    if o[1] == m:
        result.append(2)
    if o[2] == m:
        result.append(3)
    return result
