
def solution(n, m):
    answer = []
    li = [n, m]
    li.sort()
    max = 0
    for i in range(1, li[0] + 1):
        if n % i == 0 and m % i == 0:
            max = i
    
    j = 1
    while 1:
        if (li[1] * j) % li[0] == 0:
            min = int(li[1] * j)
            break
        j += 1
    
    answer = [max, min]
    return answer