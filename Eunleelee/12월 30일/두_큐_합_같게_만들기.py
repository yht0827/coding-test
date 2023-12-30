from collections import deque

def solution(queue1, queue2):
    answer = 0
    
    queue1 = deque(queue1) # 효율성을 위해 배열을 deque로 정의
    queue2 = deque(queue2)
    queue1_sum = sum(queue1) # queue1의 전체 합
    queue2_sum = sum(queue2) # queue2의 전체 합
    
    n = (queue1_sum + queue2_sum) // 2  # 두 개의 큐의 합에서 2를 나눠서 각각 만들어야 하는 합
    swap_num = 0
    max_swap = len(queue1) * 4  # 큐의 순환이 계속될 수 있기 때문에 최대 순환을 미리 정의
    
    while 1:
        switch_num = 0
        if (queue1_sum == n and queue2_sum != n) or (queue1_sum != n and queue2_sum == n):
            return -1
        else:
            # queue1의 합이 n보다 작으면 queue1의 값을 제거, queue2에 추가
            if queue1_sum < n:
                while queue1_sum < n and len(queue2) > 0:
                    switch_num = queue2[0]
                    queue2_sum -= switch_num; queue1_sum += switch_num
                    queue2.popleft()
                    queue1.append(switch_num)
                    answer += 1
                    swap_num += 1
            
            # queue2의 합이 n보다 작으면 queue2의 값을 제거, queue1에 추가
            if queue2_sum < n:
                while queue2_sum < n and len(queue1) > 0:
                    switch_num = queue1[0]
                    queue2_sum += switch_num; queue1_sum -= switch_num
                    queue1.popleft()
                    queue2.append(switch_num)
                    answer += 1
                    swap_num += 1
        
        if swap_num >= max_swap:
            return -1
        if queue1_sum == n and queue2_sum == n:
            break
        if queue1_sum <= 0 or queue2_sum <= 0:
            return -1
      
    return answer

print(solution([1, 2, 1, 2], [1, 10, 1, 2]))