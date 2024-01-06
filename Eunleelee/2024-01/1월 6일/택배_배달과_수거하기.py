def solution(cap, n, deliveries, pickups):
    # 끝에 집부터 배달해야 할 것이 없으면 삭제해준다. 배달할 것이 아예 없을 경우도 고려
    while deliveries and deliveries[-1] == 0:
        deliveries.pop()
    
    # 끝에 집부터 수거해야 할 것이 없으면 삭제해준다. 수거할 것이 아예 없을 경우도 고려
    while pickups and pickups[-1] == 0:
        pickups.pop()

    answer = 0
    while deliveries or pickups:
        answer += max(len(deliveries), len(pickups)) * 2

        deliveries_cap = pickups_cap = cap
        while deliveries:
            if deliveries[-1] <= deliveries_cap:
                deliveries_cap -= deliveries.pop()
            else:
                deliveries[-1] -= deliveries_cap
                break
        while pickups:
            if pickups[-1] <= pickups_cap:
                pickups_cap -= pickups.pop()
            else:
                pickups[-1] -= pickups_cap
                break

    return answer
