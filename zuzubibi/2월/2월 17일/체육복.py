def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()

    for i in range(1, n+1):        
        if i in reserve:
            if i+1 in lost:
                lost.pop(lost.index(i+1))
            elif i-1 in lost:
                lost.pop(lost.index(i-1)) 

    return n -len(lost)

def anotherSolution(n,lost, reserve):
    lost.sort()
    reserve.sort()

    for i in reserve[:]:
        if i in lost:
            reserve.remove(i)
            lost.remove(i)
    
    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
        elif i+1 in lost:
            lost.remove(i+1)
    return n - len(lost)


print(anotherSolution(5,[2,4],[1,3,5])) # 5
print(anotherSolution(5,[2,4],[3])) # 4
print(anotherSolution(3,[3], [1])) # 2