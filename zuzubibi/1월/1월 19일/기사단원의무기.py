def prime(n):
    cnt = 0
    for i in range(1, int(n**(1/2))+1): # 제곱근만큼만 반복 (제곱근 이상의 반복은 불필요해서 ㅎㅎ)
        if n%i ==0:
            if i == n//i: # 제곱근일 경우 (한 개만 추가함)
                cnt += 1
            else: # 제곱근이 아닐 경우 (두 개 추가)
                cnt += 2
    return cnt
    return sum(1 if n%i==0 and i == n//i else 2 for i in range(1, int(n**(1/2)) + 1))

def solution(number, limit, power):
    arr = []
    for n in range(1, number+1):
        arr.append(prime(n))
    test = list(i if i <= limit else power for i in arr)
    print(test)
    return sum( i if i <= limit else power for i in arr)

#------------------------------------------------------------------------------------
def cf(n):
    a = []
    for i in range(1, int(n**(0.5)+1)):
        if n%i==0:
            a.append(n//i)
            a.append(i)
    return len(set(a))

def anothersolution(number, limit, power):
    return sum([ cf(i) if cf(i)<=limit else power for i in range(1, number+1)])

print(anothersolution(5,3,2)) # 10
print(anothersolution(10,3,2)) # 21