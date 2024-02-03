# https://velog.io/@sunkyuj/python-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%A0%EC%82%AC-%EC%B9%B8%ED%86%A0%EC%96%B4-%EB%B9%84%ED%8A%B8%EC%97%B4

def f(n,k):
    if n ==1:
        return k if k<=2 else k-1
    div = 5**(n-1) # 나눌 수
    mul = 4**(n-1) # 1의 개수
    loc = k//div # 5개로 나눴을 때 위치 0,1,2,3,4

    if k%div ==0: # 딱 5로 나누어떨어졌을 때
        loc -= 1
    
    if loc < 2:
        return mul*loc + f(n-1, k- loc*div)
    elif loc ==2:
        return mul*loc
    else:
        return mul*(loc-1) + f(n-1, k-loc*div)
    
def solution(n, l, r):
    return f(n,r) - f(n,l-1)


print(solution(2,4,17))# 8