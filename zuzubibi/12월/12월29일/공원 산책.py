# 문제 푼 날: 23-12-29
# 문제 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172928
# 체감 난이도: ⭐️⭐️⭐️⭐️ (복습 필요)
# -------------------------------------------------------------------------
def find_start(park):
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == 'S':
                return [i, j]

def move(park, route, cur):

    goal = [a+b for a, b in zip(route, cur)]
    if not 0 <= goal[0] <= len(park) - 1: return cur
    if not 0 <= goal[1] <= len(park[0]) - 1: return cur

    if goal[0] != cur[0]:   #moving on y axis
        for i in range(min(cur[0], goal[0]), max(cur[0],goal[0])+1):
            if park[i][cur[1]] == 'X': return cur
    else:   #x axis
        for i in range(min(cur[1], goal[1]), max(cur[1], goal[1])+1):
            if park[cur[0]][i] == 'X': return cur
    return goal


def solution(park, routes):
    answer = []
    cur = find_start(park)
    direc = {'N':[-1,0], 'S':[1,0], 'E':[0,1], 'W':[0,-1]}
    for r in routes:
        route = [a * int(r[2]) for a in direc[r[0]]]
        cur = move(park, route, cur)


    return cur




print(solution(["SOO","OOO","OOO"], ["E 2","S 2","W 1"])) # [2,1]
# print(solution(["SOO","OXX","OOO"], ["E 2","S 2","W 1"])) # [0,1]
# print(solution(["OSO","OOO","OXO","OOO"], ["E 2","S 3","W 1"])) # [0,0]
