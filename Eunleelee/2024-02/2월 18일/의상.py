from collections import defaultdict

def solution(clothes):
    answer = 1
    dic = defaultdict(list)
    for i in clothes:
        dic[i[1]].append(i[0])
    for k in dic:
        answer*=len(dic[k]) + 1
    answer -= 1
    #print(dic)
    return answer
