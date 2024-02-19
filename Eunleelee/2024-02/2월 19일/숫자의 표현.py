def solution(n):
    answer = 1

    for i in range(1, int(n/2)+1):
        a =0
        j = i
        while 1:
            a += j
            if a == n:
                answer += 1
                break
            if a > n:
                break
            j += 1

    return answer
