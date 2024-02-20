def solution(brown, yellow):
    arr = []
    for i in range(1,int(yellow**(1/2))+1):
        if yellow % i ==0:
            arr.append([i,yellow//i])
    arr.sort(reverse=True)

    for col, row in arr:
        col, row = col +2, row + 2
        if (row+col-2)*2 == brown:
            return [row, col]

def anotherSolution(brown, yellow):
    for i in range(1, int(yellow**(1/2)+1)):
        if yellow % i == 0:
            if 2*(i + yellow//i) == brown-4:
                return [yellow//i+2, i+2]


print(solution(10,2)) # [4,3]
print(solution(8,1)) # [3,3]
print(solution(12,4))
print(solution(24,24)) # [8,6]