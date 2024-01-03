# 문제 전략
# number 길이 100,000 -> 이중 반복문보다 더 빠른 것 필요
# heap 사용

# 뒷 큰수: 자신보다 뒤에 있으며, 가장 크고, 가까운 수
#---------------------------------------------------------------
# 이중 포문 사용 시, 시간 초과
def not_solution(numbers):
    result = []
    for i in range(len(numbers)):
        myboy = numbers[i]
        for j in range(i+1, len(numbers)):
            if myboy < numbers[j]:
                myboy = numbers[j]
                break
        if myboy == numbers[i]:
            myboy = -1
        result.append(myboy)
  
    return result


# heap 사용
from heapq import heappop, heappush
def solution(numbers):
    answer = [-1] * len(numbers)
    heap = [(numbers[0], 0)] # 기준: (숫자, 인덱스)

    for i, n in enumerate(numbers[1:]): # 기준 보다 높은 숫자들이 담긴 배열
        while heap and heap[0][0] < n: # 새로운 수가 기준보다 클 때
            _, idx = heappop(heap)     # heap의 배열 계속 꺼내서
            answer[idx] = n            # 정답에 새로운 배열 갈아끼우기
        heappush(heap,(n, i+1))        # 만약 새로운 수가 크지 않으면 배열에 넣기
       
    return answer


numbers = [2,3,3,5]
print(solution(numbers)) # [3,5,5,-1]

numbers = [9,1,5,3,6,2]
print(solution(numbers)) # [-1,5,6,6,-1,-1]