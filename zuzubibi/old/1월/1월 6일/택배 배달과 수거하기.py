def solution(cap, n, deliveries, pickups):
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]
    answer = 0

    have_to_deli = 0
    have_to_pick = 0

    for i in range(n):
        have_to_deli += deliveries[i]
        have_to_pick += pickups[i]

        while have_to_deli > 0 or have_to_pick > 0:
            have_to_deli -= cap
            have_to_pick -= cap
            answer += (n - i) * 2

    return answer
#------------------------------------------------------------------------------
from itertools import zip_longest as zip

def tolist(l):
    n=[]
    for i,d in enumerate(l):
        for _ in range(d):
            n.append(i+1)
    return n

def anotherSolution(cap, n, deliveries, pickups):
    d=tolist(deliveries)
    p=tolist(pickups)
    d.reverse()
    p.reverse()
    d=d[::cap]
    p=p[::cap]
    return 2*sum([max(x,y) for x,y in zip(d,p,fillvalue=0)])
#-----------------------------------------------------------------------------------

# 참고 사이트: https://oh2279.tistory.com/147
print(solution(4,5,[1, 0, 3, 1, 2],[0, 3, 0, 4, 0])) # 16
print(solution(2,7,[1, 0, 2, 0, 1, 0, 2], [0, 2, 0, 1, 0, 2, 0])) # 30
