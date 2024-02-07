def solution(n, m, section):
    arr = [i if i not in section else 0 for i in range(n+2) ]
    cnt = 0
    for i in range(1, len(arr)):
        if arr[i] != 0:
            continue
        else:
            for j in range(i, i+m):
                arr[j] = j
            cnt += 1
    return cnt

# ----------------------------------------------------------------
def anotherSoultion(n,m,section):
    answer, paint = 0,0

    for s in section:
        if s >= paint:
            paint = s+m
            answer += 1
    return answer

print(solution(8,4,[2,3,6])) # 2
print(solution(5,4,[1,3])) # 1
print(solution(4,1,[1,2,3,4])) # 4
