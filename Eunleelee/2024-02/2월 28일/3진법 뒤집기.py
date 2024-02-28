def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)

    return convert(q, base) + T[r] if q else T[r]

def solution(n):
    answer = 0
    n = convert(n, 3)
    n = str(n)
    n = n[::-1]
    answer = int(n, 3)
    return answer
