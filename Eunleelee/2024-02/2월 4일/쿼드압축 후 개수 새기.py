def check(arr):
    number = arr[0][0]
    for i in arr:
        for j in i:
            if number != j:
                return False
    return True

def solution(arr):
    n = len(arr)

    if n==1 or check(arr):
        if arr[0][0] == 0:
            return 1,0
        return 0,1

    z1,o1 = solution([i[:n//2] for i in arr[:n//2]])
    z2,o2 = solution([i[n//2:] for i in arr[:n//2]])
    z3,o3 = solution([i[:n//2] for i in arr[n//2:]])
    z4,o4 = solution([i[n//2:] for i in arr[n//2:]])

    return [z1+z2+z3+z4,o1+o2+o3+o4]