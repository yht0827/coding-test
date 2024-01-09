def solution(a, b):
    return sum( i*j for i,j in zip(a,b))


print(solution([1,2,3,4], [-3,-1,0,2])) # 3
print(solution([-1,0,1], [1,0,-1])) # -2