def solution(d, budget):
    d. sort()
    cnt = 0
    
    for i in d:
        budget -= i

        if budget < 0:
            break

        cnt += 1
        print((budget, cnt), end=" ")
    return cnt

print(solution([1,3,2,5,4], 9)) # 3
print(solution([2,2,3,3], 10)) # 4