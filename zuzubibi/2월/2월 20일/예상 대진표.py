def solution(n,a,b):
    answer= 0
    while a!=b:
        answer +=1
        a,b = (a+1)//2, (b+1)//2
        # +1 한 뒤 2로 나눈 몫을 저장하는 이유는
        # a,b가 홀수이건 짝수이건 1을 더해서 몫으로 나누면
        # 다음 라운드의 번호를 구할 수 있음
    return answer

print(solution(8,4,7)) # 3