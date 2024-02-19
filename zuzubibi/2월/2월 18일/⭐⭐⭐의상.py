def solution(clothes):

    # 1. 옷을 종류별로 구분하기
    hash_map = {}
    for clothe, type in clothes:
        hash_map[type] = hash_map.get(type, 0) + 1
        
    # 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
    answer = 1
    for type in hash_map:   
        answer *= (hash_map[type] + 1)
    
    # 3. 아무종류의 옷도 입지 않는 경우 제외하기
    return answer - 1

def anotherSolution(clothes):
    closet = {}
    for name, kind in clothes:
        if kind in closet:
            closet[kind] += [name]
        else:
            closet[kind] = [name]
    
    answer =1
    for _, value in closet.items():
        answer *= (len(value)+1)
    return answer -1

from collections import Counter
from functools import reduce
def CounterSolution(clothes):
    counter = Counter([type for clothe, type in clothes])

    answer = reduce(lambda acc, cur: acc*(cur+1), counter.values(),1)-1
    return answer

# 5
print(anotherSolution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))

# 3
print(CounterSolution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))