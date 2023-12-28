# 문제 푼 날: 23-12-28
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150368
#---------------------------------------------------------------------------
# 문제
# 우선순위는 1. 가입자 증가  2. 매출 증가 순이다.
# 사용자 n명이 이모티콘 m개를 할인 받아 예산 내에서 산다.
# 이모티콘마다 할인율이 다르다. (10% 20% 30% 40%)

# [사용자 구매 기준 & 가입 기준]
# 각 사용자가 일정 비율 이상 할인되면 구매 
# (구매 비용의 합 >= 일정가격) 이 되면, 구매를 취소하고, 가입자가 된다.
#--------------------------------------------------------------------------
# 내 풀이
# 전략: 조합

def mysolution(users, emoticons):
    discount_rates = [10, 20, 30, 40]
    selling_emoticons = [[int((100 - rate)*emoticon*0.01), emoticon] for emoticon in emoticons for rate in discount_rates]
    print(selling_emoticons)
    for user in users:
        print(user)
    return 

# print(mysolution([[40, 10000], [25, 10000]], [7000, 9000]))  # [1, 5400]
# print(mysolution([[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]], [1300, 1500, 1600, 4900])) # [4, 13860] 

# 어떻게 풀어야할지 잘 모르겠다..

#--------------------------------------------------------------------------
# [ 다른 사람 풀이 ]
# 전략
# 간단한 규칙 기반 알고리즘입니다.
# 할인율(rate)에 대해서 product(중복 순열)을 만들어주고
# 각 할인율 배열에 대해서 계산한 후
# 플러스 갯수, 가격에 대해서 정렬하고 리턴하면 됩니다.
from itertools import product

def solution(users, emoticons):
    discount_rates = [10, 20, 30, 40]
    result = []

    # 이모티콘 별 할인율의 모든 조합(중복 순열) 구하기
    discount_cases = list(product(discount_rates, repeat=(len(emoticons))))
    
    for discount_case in discount_cases:
        member = 0
        income = 0
        for required_discount, budget in users:
            purchased = 0

            for i in range(len(emoticons)):
                # 각 사용자가 구매할 이모티콘
                # 각 조합별 모든 이모티콘을 순회하며 경우의 수 구하기
                if required_discount <= discount_case[i]:
                    # 한 사용자 구매액은 자신의 기준 할인율 이상 할인하는 이모티콘의 할인가
                    purchased += int(emoticons[i] - emoticons[i]*discount_case[i] *0.01)
            if purchased >= budget:
                member += 1
            else:
                income += purchased
                
        # 할인율 조합별 (총 가입자 수, 판매액)을 배열에 저장
        result.append((member, income))
    # 조합별 가장 가입자 수 > 판매액 순으로 큰 경우를 찾아 리턴
    result.sort(reverse=True, key= lambda x: (x[0], x[1]))
    # print(result[0])
    return list(result[0])
        
    
# print(solution([[40, 10000], [25, 10000]], [7000, 9000]))  # [1, 5400]
# print(solution([[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]], [1300, 1500, 1600, 4900])) # [4, 13860] 

