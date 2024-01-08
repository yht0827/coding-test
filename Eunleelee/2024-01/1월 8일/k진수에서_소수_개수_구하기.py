import math
import string

# 18분 소요
# n에 제곱근(가운데 약수)까지만 확인하면 소수인지 판별 가능
def is_prime_number(n):
  if n < 2:
     return False
   
  for i in range(2, int(math.sqrt(n)) + 1):
    if n % i == 0:
      return False
  return True

# 10진수 -> n진수 변환
tmp = string.digits + string.ascii_lowercase
def convert(num, base):
    q, r = divmod(num, base)
    if q == 0:
       return tmp[r]
    else:
       return convert(q, base) + tmp[r]

def solution(n, k):
    change_n = convert(n, k)  # n을 k진법으로 변환

    answer = 0
    num = ''

    for i in change_n:
        if i != '0':
          num += i
        elif i == '0' and num:
          if is_prime_number(int(num)):
            answer += 1
          num = ''
    
    # 마지막으로 남은 숫자들이 있다면 확인
    if num and is_prime_number(int(num)):
       answer += 1
      
    return answer

print(solution(110011, 10))