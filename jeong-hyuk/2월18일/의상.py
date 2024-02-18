from collections import defaultdict

def solution(clothes):
    closet = defaultdict(int)
    #의상의 종류별로 개수를 셈
    for cloth, kind in clothes:
        closet[kind] += 1
    
    #의상을 선택하는 경우의 수를 구함
    answer = 1
    for count in closet.values():
        #해당 종류의 의상을 입지 않는 경우도 고려하여 +1
        answer *= (count + 1)
    
    #모든 의상을 입지 않는 경우를 제외함
    return answer - 1