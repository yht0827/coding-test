def solution(food):
    arr = "".join([f'{i}'*(data//2) for i,data in enumerate(food)]).strip()
    return arr + "0" + arr[::-1]
print(solution([1,3,4,6]))
print(solution([1,7,1,2]))
