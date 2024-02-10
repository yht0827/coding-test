from collections import defaultdict as dd
def solution(numbers, target):
    a = [0]
    d = dd(int)
    d[0] = 1
    for n in numbers:
        nd = dd(int)
        na = []
        for i in a:
            if i+n not in nd:
                na.append(i+n)
            if i-n not in nd:
                na.append(i-n)
            nd[i+n] += d[i]
            nd[i-n] += d[i]
        d = nd
        a = na
    return d[target]