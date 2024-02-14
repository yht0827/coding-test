def solution(X, Y):
    answer = ''
    num = '0123456789'
    n = ''
    for i in range(9, -1, -1):
        x = X.count(num[i])
        y = Y.count(num[i])
        if x != 0 and y != 0:
            if x < y:
                n = n + num[i] * x
            elif x > y:
                n = n + num[i] * y
            elif x == y:
                n = n + num[i] * x
            X = X.replace(num[i], '')
            Y = Y.replace(num[i], '')
        elif x == 0 and y != 0:
            Y = Y.replace(num[i], '')
        elif x != 0 and y == 0:
            X = X.replace(num[i], '')
    if len(n) == 0:
        answer = '-1'
    elif n[0] == '0':
        answer = '0'
    else:
        answer = n
    return answer