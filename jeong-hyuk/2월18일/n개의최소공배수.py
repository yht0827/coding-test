import math

def solution(arr):
    #두 수의 최소공배수를 계산하는 함수
    def lcm(a, b):
        return a * b // math.gcd(a, b)

    #주어진 숫자들의 최소공배수를 구함
    answer = arr[0]
    for num in arr[1:]:
        answer = lcm(answer, num)
    
    return answer