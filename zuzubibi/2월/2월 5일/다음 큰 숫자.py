def solution(n):
    #print(n, bin(n)[2:], int(bin(n)[2:],2))
    origin = bin(n)[2:]
    #print(origin, type(origin))
    #print(origin.count('1'))
    now = n
    while True:
        now +=1
        now_binary = bin(now)[2:]
        if now_binary.count('1')==origin.count('1'):
            return now
print(solution(78)) # 83
print(solution(15)) # 23

