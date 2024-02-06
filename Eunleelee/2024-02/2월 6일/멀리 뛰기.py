def solution(n):
    arr = [0 for i in range(2002)]
    arr[1] = 1
    arr[2] = 1
    
    for i in range(1, n):
        if arr[i] != 0:
            arr[i+1] += arr[i] 
            arr[i+2] += arr[i]
    
    answer = arr[n] % 1234567
    return answer