def solution(n):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, 3)
        rev_base += str(mod)
    
    return int(rev_base, 3)


print(solution(45)) # 7
print(solution(125)) # 229