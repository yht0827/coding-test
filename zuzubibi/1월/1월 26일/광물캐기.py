def solution(picks, minerals):
    sum = 0
    for x in picks:
        sum += x
    
    # 캘 수 있는 광물의 개수
    num_min = sum * 5
    if len(minerals) > num_min: # 주어진 광물이 캘 수 있는 광물 수보다 크면
        minerals = minerals[:num_min]
    
    # 광물 조사
    cnt_min = [[0,0,0] for _ in range(10)] # dia, iron, stone
    for i in range(len(minerals)):
        if minerals[i] == 'diamond':
            cnt_min[i//5][0] += 1
        elif minerals[i] == 'iron':
            cnt_min[i//5][1] += 1
        else:
            cnt_min[i//5][2] += 1
    
    # 피로도가 높은 순서대로 광물 정렬
    sorted_cnt_min = sorted(cnt_min, key=lambda x: (-x[0], -x[1], -x[2]))
    print(sorted_cnt_min)
    
    # 피로도 계산
    answer = 0
    for minerals in sorted_cnt_min:
        d,i,s = minerals
        for p in range(len(picks)):
            if p ==0 and picks[p] >0: # dia 곡괭이
                picks[p] -= 1
                answer += d + i + s
                break
            elif p == 1 and picks[p] >0: # iron 곡괭이
                picks[p] -= 1
                answer += 5*d + i + s
                break
            elif p ==2 and picks[p] >0: # stone 곡괭이
                picks[p] -= 1
                answer += 25*d + 5*i + s
                break
    return answer

# 12
print(solution([1, 3, 2],["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]))

# 50
print(solution([0, 1, 1], ["diamond", "diamond", "diamond", "diamond", "diamond","iron", "iron", "iron", "iron", "iron", "diamond"]))