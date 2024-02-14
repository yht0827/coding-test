def solution(n):
    return list(int(i) for i in str(n)[::-1])


def anotherSolution(n):
    return list(map(int, reversed(str(n))))

def anotherSolutino(n):
    return [int(i) for i in str(n)][::-1]

print(solution(12345)) # [5,4,3,2,1]