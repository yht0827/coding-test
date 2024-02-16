import math
 
def solution(n, k):
    arr = [i for i in range(1, n + 1)]
    answer = []
    
    while arr:
        a = (k - 1) // math.factorial(n - 1)
        answer.append(arr.pop(a))
 
        k = k % math.factorial(n - 1)
        n -= 1
 
    return answer
