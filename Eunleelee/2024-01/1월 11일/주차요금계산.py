import math

def solution(fees, records):
    answer = []
    entrance = {}  # 출입한 차 번호와 시간을 저장
    exits = {}  # 나가는 차 번호와 시간을 저장
    
    for record in records:
        info = record.split(' ')
        # 계산 하기 쉽게 hour * 60 + minutes로 계산해서 저장
        time = (int(info[0][:2]) * 60) + int(info[0][3:])
        if info[2] == "IN":
            entrance[info[1]] = time
        else:
            # 이미 출차 기록이 있는 차라면
            if info[1] in exits:
                exits[info[1]] += time - entrance[info[1]]
            else:
                exits[info[1]] = time - entrance[info[1]]
            
            del entrance[info[1]] # 들어온 기록은 삭제

    last_time = 23 * 60 + 59  # 가장 나중 시간을 기록

    # 들어온 기록만 있고 나간 기록은 없을 때
    if entrance:
        for num, time in entrance.items():
            if num in exits:
                exits[num] += last_time - time
            else:
              exits[num] = last_time - time
    
    exits = sorted(exits.items())  # 차 번호가 작은것부터 시작

    for exit in exits:
        if exit[1] <= fees[0]:
            answer.append(fees[1])
        else:
            answer.append(math.ceil((exit[1] - fees[0]) / fees[2]) * fees[3] + fees[1]) 
        
    return answer

print(solution([180, 5000, 10, 600],	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))