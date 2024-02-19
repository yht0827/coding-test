def solution(s):
    a = [int(i) for i in s.split()]
    return ' '.join([str(min(a)), str(max(a))])

def anotherSolutino(s):
    s = list(map(int, s.split()))
    return str(min(s)) + ' ' + str(max(s))

print(solution("1 2 3 4")) # "1 4"
print(solution("-1 -2 -3 -4")) # "-4 -1"
print(anotherSolutino("-1 -1")) #"-1 -1"