# 문제 푼 날: 23-12-28
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/154538
#-----------------------------------------------------------------------------------
# 문제 
# x를 y로 변환하는데 사용할 수 있는 연산은 3가지이다.
# 1. x + n
# 2. x * 2
# 3. x * 3
# 연산을 사용해서 y로 변환할 수 있다면 return 가장 적은 횟수로 변환된 횟수, 변환할 수 없다면 return -1 
#------------------------------------------------------------------------------------
# 나의 풀이
def mysolution(x,y,n):
    cnt = -1
    if y % (x+n) == 0:
        y //= (x+n)
        cnt += 1
        while y != 1:
            if y % 2==0:
                y //= 2
            elif y % 3==0:
                y //= 3
            cnt+=1
                
    elif y % x ==0:
        y //= x
        while y != 1:
            if y % 2== 0:
                y //= 2
            elif y % 3 == 0:
                y //= 3
            cnt += 1
    
    return cnt

# print(mysolution(10,40,5))     # 2
# print(mysolution(10,40,30))    # 1
# print(mysolution(2,5,4))       # -1

# 테스트 케이스 5,7,9,10,11,14,16 통과 못함

#----------------------------------------------------------------
# 문제 팁
# 풀이 자체는 잘못 된게 아닌데
# 그렇게 풀면 레벨1급 문제입니다.

# 레벨2로 측정된 이유가 있습니다.

# 상향식으로 접근한다면
# DFS로 푼다면 아마 최대재귀가능횟수 초과 오류,
# 혹은 제한을 풀거나 BFS로 한다면 시간초과가 발생할탠데

# 반대로 하향식으로 접근하면 가능한 수를 훨신 줄일 수 있습니다.
# x에서 시작하는 게 아니라
# y에서 시작하는겁니다.
#---------------------------------------------------------------
def solution(x,y,n):
    answer = -1
    queue = []
    queue.append([y, 0])

    while len(queue) > 0:
        now = queue.pop(0)
        if now[0] == x:
            return now[1]
        if now[0] > 0:
            if now[0] % 2 == 0:
                queue.append([now[0]//2, now[1]+1])
            if now[0] % 3 == 0:
                queue.append([now[0]//3, now[1]+1])
            queue.append([now[0]-n, now[1]+1])
    return answer



# print(solution(10,40,5))     # 2
# print(solution(10,40,30))    # 1
# print(solution(2,5,4))       # -1

#--------------------------------------------------------------------
# [ 따봉 정답 ]
# 특징
# 1. 중복 요소 제거를 set으로 함
# 2. 파생될 수 있는 3가지 연산 결과를 다 set에 담고 그 중 y와 동일한 수가 있다면 return answer
# 3. 만약 동일한 수가 없다면 기존 set()을 설정한 s에 담고 새롭게 다시 연산을 함
# 파생될 수 있는 수를 모두 조사하는 방식.. ㄷㄷ 엄청 깔끔하고 직관적인 풀이
def goodsolution(x,y,n):
    answer =0 
    s = set()
    s.add(x)

    while s:
        if y in s:
            return answer

        nxt = set()
        for i in s:
            if i+n <= y:
                nxt.add(i+n)
            if i*2 <= y:
                nxt.add(i*2)
            if i*3 <= y:
                nxt.add(i*3)
        s = nxt
        answer += 1
    return -1


print(goodsolution(10,40,5))     # 2
print(goodsolution(10,40,30))    # 1
print(goodsolution(2,5,4))       # -1
