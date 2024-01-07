def solution(weights):
    weights.sort()
    result = 0
    for x in range(len(weights)-1):
        for y in range(x+1, len(weights)):
            if weights[x] == weights[y]:
                result +=1
            elif weights[x]*4 == weights[y]*2:
                result+= 1
            elif weights[x]*4 == weights[y]*3:
                result+=1
            elif weights[x]*3 == weights[y]*2:
                result+=1
    return result

# -----------------------------------------------------
from collections import defaultdict

def solution(weights):
    answer =0
    dic = defaultdict(int)
    weights.sort()
    for weight in weights:
        if dic[weight]:
            answer += dic[weight]
        dic[weight] += 1
        if weight % 2==0:
            dic[(weight//2)*3] += 1
        if weight % 3 ==0:
            dic[(weight//3)*4] += 1
        dic[weight * 2] += 1
    return answer
#--------------------------------------------------------
from itertools import combinations
from collections import Counter

def solution(weights):
    cnt = 0
    weights = Counter(weights)
    for a,b in combinations(weights.keys(), 2):
        if a*2 == b*3 or a*2 == b*4 or a*3 == b*4 or b*2 == a*3 or b*2 == a*4 or b*3 == a*4:
            cnt += weights[a]*weights[b]
    for v in weights.values():
        if v >1:
            cnt += sum([i for i in range(1,v)])
    return cnt

print(solution([100,180,360,100,270])) # 4