def solution(X, Y):
    x_arr = [0] *10
    y_arr = [0] *10

    for num in set(X):
        x_arr[int(num)] += X.count(num)
    for n in set(Y):
        y_arr[int(n)] += Y.count(n)

    result = ""
    for i in range(9,-1,-1):
        if x_arr[i] and y_arr[i]:
            if result=="" and i == 0:
                result += str(i)
            else:
                result += str(i) * min(x_arr[i], y_arr[i])

    return result or "-1"
# -----------------------------------------------------------
def anothersolution(X,Y):
    answer = ''
    for i in range(9,-1,-1):
        answer += str(i)*min(X.count(i), Y.count(i))

    if answer == '':
        return "-1"
    elif len(answer) == answer.count('0'):
        return '0'
    else:
        return answer
print(solution("100", "2345")) # "-1"
print(solution("100", "203045")) # "0"
print(solution("100", "123450")) # "10"
print(solution("12321", "42531")) # "321"
print(solution("5525", "1255")) # "552"