# 1. 과제를 끝내는 시간이 다음 과제 시작하는 시간인 경우
# 2. 과제를 끝내는 시간이 다음 과제 시작하는 시간보다 지난 경우
# 3. 과제를 끝내는 시간이 다음 과제 시작하는 시간보다 이전인 경우
# 3-1. 남은 과제가 있는 경우 남은 과제를 처리


def solution(plans):
    plans = sorted(plans, key=lambda x:x[1])
    plans_len = len(plans) - 1
    remain = []
    answer = []
    
    for i, plan in enumerate(plans):
        if i == plans_len:
            answer.append(plan[0])
            if remain:
                for i in range(len(remain)-1, -1, -1):
                    answer.append(remain[i][0])
        else:
            now_time = int(plan[1][:2]) * 60 + int(plan[1][3:]) + int(plan[2])
            next_start_time = int(plans[i+1][1][:2]) * 60 + int(plans[i+1][1][3:])
            remain_time = next_start_time - now_time
            
            if remain_time == 0:
                answer.append(plan[0])
            elif remain_time < 0:
                remain.append([plan[0], abs(remain_time)])
            elif remain_time > 0:
                answer.append(plan[0])
                while remain:
                    if remain[-1][1] < remain_time:
                        remain_time -= remain[-1][1]
                        answer.append(remain[-1][0])
                        remain.pop()
                    elif remain[-1][1] == remain_time:
                        answer.append(remain[-1][0])
                        remain.pop()
                        break
                    else:
                        remain[-1][1] -= remain_time
                        break
                            
            
    return answer