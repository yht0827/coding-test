def solution(n):
    def hanoi(n, rod1=1, rod3=3, rod2=2):
        if n==1:
            answer.append([rod1, rod3])
        else:
            hanoi(n-1,rod1, rod2, rod3)
            answer.append([rod1, rod3])
            hanoi(n-1, rod2, rod3, rod1)
    answer = []
    hanoi(n,1,3,2)
    return answer


# [[1,2], [1,3], [2,3]]
print(solution(2))