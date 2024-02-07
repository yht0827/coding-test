import numpy as np
def solution(id_list, report, k):
    citizen = {f:i for i, f in enumerate(id_list)}
    reported = [[0]*len(id_list) for _ in range(len(id_list))]

    for re in report:
        x,y = re.split()
        reported[citizen[x]][citizen[y]] += 1

    arr = np.array(reported)
    print(arr)

    total_reported = arr.sum(axis=0)
    print(total_reported)

    point = []
    for i, v in enumerate(total_reported):
        if v >= k:
            point.append(i)
    print(point)

    for i in range(len(arr)):
        for j in range(len(arr)):
            # if j in point:
            #     print(arr[i][j], end=" ")
            print(arr[i][j], end= " ")
        print()       
    return 
#=====================================================================
from collections import defaultdict
def anotherSolution(id_list, report, k):
    answer = []
    report = list(set(report))
    user = defaultdict(set)
    cnt = defaultdict(int)

    for r in report:
        a,b = r.split()
        user[a].add(b)
        cnt[b] += 1


    for i in id_list:
        result = 0
        for u in user[i]:
            if cnt[u]>= k:
                result += 1
        answer.append(result)
    return answer

print(anotherSolution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],2 )) # [2,1,1,0]
print(anotherSolution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3)) # [0,0]