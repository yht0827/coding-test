def solution(n):
    return "*"*(len(n)-4) + n[len(n)-4:]

print(solution("01033334444"))
print(solution("027778888"))