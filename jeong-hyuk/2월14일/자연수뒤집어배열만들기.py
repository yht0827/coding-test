def solution(n):
    arr = []
    result = list(str(n))
    x = list(map(int, result))
    for i in reversed(range(len(x))):
        arr.append(x[i])

    return arr
    