def solution(n, l, r):
    answer = 0

    for l in range(l-1, r):
        if check(l):
            answer += 1

    return answer

def check(i):
    if i % 5 == 2:
        return False
    if i < 5:
        return True


    return check(i // 5)
