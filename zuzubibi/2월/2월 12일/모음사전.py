def solution(word):
    # 등비수열을 사용한 풀이법
    answer = 0
    for i,n in enumerate(word):
        answer += (5 **(5-i) -1) / (5-1) * "AEIOU".index(n) + 1
    return answer

#-----------------------------------------------------------------
from itertools import product
def anotherSolution(word):
    answer = []
    dic = ['A', 'E','I','O','U']

    for i in range(1,6):
        for per in product(dic, repeat=i):
            answer.append(''.join(per))
    answer.sort()

    return answer.index(word)+1

print(anotherSolution("AAAAE")) # 6
print(anotherSolution("AAAE")) # 10
print(anotherSolution("I")) #1563
print(anotherSolution("EIO")) #1189
