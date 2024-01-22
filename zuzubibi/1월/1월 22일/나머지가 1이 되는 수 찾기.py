def solution(n):
    cnt = 1
    while True:
        if n % cnt == 1:
            return cnt 
        cnt += 1

def anotherSolution(n):
    arr = [x for x in range(1, n+1) if n%x ==1]
    print(arr)
    return [x for x in range(1, n+1) if n%x ==1][0]


print(anotherSolution(10)) # 3
print(anotherSolution(12)) # 11