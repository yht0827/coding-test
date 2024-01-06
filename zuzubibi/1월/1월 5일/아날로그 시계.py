def solution(h1, m1, s1, h2, m2, s2):
    answer = 0

    # 시작시간과 끝시간을 초단위로 변환
    startTime = h1 * 3600 + m1 * 60 + s1
    endTime = h2 * 3600 + m2 * 60 + s2  

    # next기준으로 계산할거니 포함되지 않는 시작시간 00시, 12시 미리 카운팅
    if startTime == 0 * 3600 or startTime == 12 * 3600:
        answer += 1

    while startTime < endTime:
        # 시침 1시간 = 30도 -> 1초에 30/3600도 즉, 1/120도 이동
        # 분침 1분 = 6도 -> 1초에 6/60도 즉, 1/10도 이동
        # 초침 1초 = 6도 -> 1초에 6도 이동 
        hCurAngle = startTime / 120 % 360
        mCurAngle = startTime / 10 % 360
        sCurAngle = startTime * 6 % 360

        # 다음 위치가 360도가 아닌 0도로 계산되어 카운팅에 포함되지 않는 경우 방지
        # 이동했을 때 지나쳤거나 같아졌는지를 비교하는 것이므로 현재위치는 해줄 필요없음
        hNextAngle = 360 if (startTime + 1) / 120 % 360 == 0 else (startTime + 1) / 120 % 360
        mNextAngle = 360 if (startTime + 1) / 10 % 360 == 0 else (startTime + 1) / 10 % 360
        sNextAngle = 360 if (startTime + 1) * 6 % 360 == 0 else (startTime + 1) * 6 % 360

        if sCurAngle < hCurAngle and sNextAngle >= hNextAngle:
            answer += 1
        if sCurAngle < mCurAngle and sNextAngle >= mNextAngle:
            answer += 1
        # 시침/분침과 동시에 겹쳤을 때 중복카운팅 제외 
        if sNextAngle == hNextAngle and hNextAngle == mNextAngle:
            answer -= 1

        startTime += 1
    
    return answer
#-------------------------------------------------------------------------------------
def anotherSolution(h1,m1,s1,h2,m2,s2):
    answer = 0
    start = h1 *3600 + m1 * 60 + s1
    end= h2 * 3600 + m2 * 60 + s2
    
    answer += int(end/3600*59)
    answer -= start//(3600/59)
    answer += end//(360*120/719)
    answer -= start//(360*120/719)
    if start <= 12 * 60 * 60 <= end:
        answer -= 1
    if start == 0 or start == 12*60*60:
        answer += 1
    
    return int(answer)



print(anotherSolution(0,5,30,0,7,0)) # 2
print(anotherSolution(12,0,0,12,0,30)) # 1
print(anotherSolution(0,6,1,0,6,6)) # 0
print(anotherSolution(11,59,30,12,0,0)) # 1
print(anotherSolution(11,58,59,11,59,0)) # 1
print(anotherSolution(1,5,5,1,5,6)) # 2
print(anotherSolution(0,0,0,23,59,59)) # 2852
