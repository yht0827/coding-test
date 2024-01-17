from collections import deque
def solution(bandage, health, attacks):
    is_cure = 0
    is_attacked = False
    now_health = health

    # 시전시간, 초당 회복량, 추가 회복량
    b_time, b_healing, b_plus = bandage
    attacks = deque(attacks)

    for time in range(1, attacks[-1][0]+1):
        
        for at_time, at_damage in attacks:
            # 빨리 패스
            if at_time > time:
                continue
            # 특정 시간에 공격받음
            elif at_time == time:
                now_health -= at_damage
                is_cure = 0
                attacks.popleft()
                is_attacked = True
                # 만약 체력이 0 이하라면 -1 리턴
                if now_health <= 0:
                    return -1
                break
        # 공격 안 당함
        if not is_attacked:
            now_health += b_healing
            is_cure += 1

            # 체력 연속 회복 되면 추가 회복함
            if is_cure == b_time:
                is_cure = 0
                now_health += b_plus

            # 만약 체력이 오버되면 피통만큼 할당하기
            now_health = min(now_health, health)
        is_attacked = False  
        # print(time, now_health, is_cure, is_attacked)
        # print(attacks)
    return now_health


print(solution([5, 1, 5],30,[[2, 10], [9, 15], [10, 5], [11, 5]])) # 5
print(solution([3, 2, 7],20,[[1, 15], [5, 16], [8, 6]])) #-1
print(solution([4, 2, 7],20,[[1, 15], [5, 16], [8, 6]])) # -1
print(solution([1, 1, 1],5,[[1, 2], [3, 2]])) # 3
