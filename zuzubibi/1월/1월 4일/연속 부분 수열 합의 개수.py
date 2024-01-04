# 문제 전략
# 중복 제거를 위해 []보단 set 사용
# --------------------------------------------------------------------

def solution(elements):
    ll = len(elements)
    res = set()

    for i in range(ll):
        ssum = elements[i]
        res.add(ssum)
        for j in range(i+1, i+ll):
            ssum += elements[j%ll]
            res.add(ssum)
    return len(res)

print(solution([7,9,1,1,4]))  # 18