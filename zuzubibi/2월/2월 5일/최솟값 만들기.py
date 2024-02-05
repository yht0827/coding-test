from itertools import permutations
import math
def solution(A,B): 
    result = 999999999
    for i in set(permutations(B)):
        sum_ = 0
        for j in zip(A,i):
            sum_ += math.prod(j)
        result = min(sum_, result)
    return result

def antherSolution(A,B):
    answer = 0
    A.sort(reverse = True)
    B.sort()
    for i in range(len(A)):
        answer += (A[i]*B[i])
    return answer

def anotherSolution(A,B):
    return sum(a*b for a,b in zip(sorted(A), sorted(B, reverse=True)))
print(anotherSolution([1,4,2], [5,4,4])) # 29
print(anotherSolution([1,2], [3,4])) # 10