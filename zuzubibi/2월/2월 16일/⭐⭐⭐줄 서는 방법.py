from itertools import permutations
def solution(n, k):
    return list(list(permutations(range(1,n+1), n))[k-1])

import math
def anotherSolution(n,k):
    arr = [i for i in range(1, n+1)]
    answer = []

    while arr:
        a = (k-1) // math.factorial(n-1)
        answer.append(arr.pop(a))

        k %= math.factorial(n-1)
        n-=1

        print(arr, a,answer,k,n)

    return answer

print(anotherSolution(3,5)) # [3,1,2]