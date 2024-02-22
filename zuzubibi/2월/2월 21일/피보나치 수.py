def solution(n):
    arr = [0,1]
    for i in range(2, n+1):
        arr.append((arr[i-1] + arr[i-2]) %1234567)
    return arr[-1]

def anothersolution(n):
    a,b = 0,1
    for _ in range(n):
        a,b = b, (a+b)%1234567
    return a
print(anothersolution(3)) # 2
print(anothersolution(5)) # 5