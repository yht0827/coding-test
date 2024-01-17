def solution(n,m):
    gcd = 0 # 최대 공약수 (greatest common factor)
    lcm = 0 # 최소 공배수 (least common multiple)

    for i in range(min(n,m), 0, -1):
        if n % i == 0 and m % i == 0:
            gcd = i
            break
        
    lcm = (n*m) // gcd

    return [gcd, lcm]

print(solution(3,12)) # [3,12]
print(solution(2,5)) # [1,10]

