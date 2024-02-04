def solution(edges):
    answer = [0,0,0,0]

    exchangeCnts = {}
    for a,b in edges:
        if not exchangeCnts.get(a):
            exchangeCnts[a] = [0,0]
        if not exchangeCnts.get(b):
            exchangeCnts[b] = [0,0]

        # 준 것, 받은 것 카운팅
        # a, b는 a가 b에 준 것, b가 a에게 받은 것
        exchangeCnts[a][0] += 1
        exchangeCnts[b][1] += 1

    for key, exchangeCnt in exchangeCnts.items():
        if exchangeCnt[0] >=2 and exchangeCnt[1] == 0:
            answer[0] = key
        elif exchangeCnt[0] ==0 and exchangeCnt[1] > 0:
            answer[2] += 1
        elif exchangeCnt[0] >=2 and exchangeCnt[1] >= 2:
            answer[3] += 1

    answer[1] = (exchangeCnts[answer[0]][0] - answer[2] - answer[3])
    return answer

# [2, 1, 1, 0]
print(solution([[2, 3], [4, 3], [1, 1], [2, 1]]))
# [4, 0, 1, 2]
print(solution([[4, 11], [1, 12], [8, 3], [12, 7], [4, 2], [7, 11], [4, 8], [9, 6], [10, 11], [6, 10], [3, 5], [11, 1], [5, 3], [11, 9], [3, 8]]))