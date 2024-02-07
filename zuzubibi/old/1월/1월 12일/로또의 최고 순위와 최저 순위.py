def calc_rank(count):
    return 6 if count < 2 else 7-count
def solution(lottos, win_nums):
    double = 0
    origin = 0
    for i in lottos:
        if i in win_nums:
            origin += 1
        elif i == 0:
            double += 1
    min_rank = calc_rank(origin)
    max_rank = calc_rank(origin + double)
    return [max_rank, min_rank]
#-----------------------------------------------------------------
def anotherSolution(lottos, win_nums):
    rank = [6,6,5,4,3,2,1]

    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans], rank[ans]


print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])) # [3, 5]
print(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25])) # [1, 6]
print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35])) # [1, 1]