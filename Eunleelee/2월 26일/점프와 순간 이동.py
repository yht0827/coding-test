def solution(n):
    ans = 1
    while 1:
        if n % 2 != 0 and n != 1:
            n = n - 1
            ans += 1
        n = n / 2
        if n <= 1:
            break
    

    return ans
