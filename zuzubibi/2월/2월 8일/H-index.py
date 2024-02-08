def solution(citations):
    answer = 0

    n = len(citations)
    citations.sort()

    for i in range(n):
        hIndex = n-i

        if citations[i] >= hIndex:
            answer= hIndex
            break

    return answer

# 3
print(solution([3,0,6,1,5]))