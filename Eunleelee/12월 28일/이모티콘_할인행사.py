from itertools import product

# 최우선 순위는 이모티콘 플러스에 가입시키는 것

def solution(users, emoticons):
  result = []
  discount_table = [10, 20, 30, 40]

  # 할인율을 이모티콘의 길이만큼 모든 경우의 수를 나타낸다.
  discount = list(product(discount_table, repeat=len(emoticons)))

  for rate in discount:
    member = 0
    income = 0

    for min_discount, budget in users:
      price = 0

      # 최소 할인율을 넘는 이모티콘을 산다면 나오는 가격
      for i in range(len(emoticons)):
        if min_discount <= rate[i]:
          price += emoticons[i] - emoticons[i] * rate[i] * 0.01

      # 예산보다 이모티콘 구매 가격이 높다면 이모티콘 플러스 가입자 추가
      if price >= budget:
        member += 1

      # 예산이 이모티콘 구매 가격보다 낮다면 수익에 이모티콘 구매 가격을 더해줌
      else:
        income += price
    
    result.append((member, income))
  
  #이모티콘 플러스 가입자를 우선으로 내림차순, 수익을 그 다음으로 내림차순
  answer = sorted(result, reverse=True, key=lambda x: (x[0], x[1]))

  return answer[0]

solution([[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]], [1300, 1500, 1600, 4900])