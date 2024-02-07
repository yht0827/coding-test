from itertools import combinations
def solution(orders, course):
    answer = []

    for course_item in course:
        comb_count = {}

        for order in orders:
            order_comb = combinations(list(order), course_item)

            for order in order_comb:
                order_comb_string = "".join(sorted(order))

                if comb_count.get(order_comb_string):
                    comb_count[order_comb_string] += 1
                
                else:
                    comb_count[order_comb_string] = 1
        # print(comb_count)
        max_order = [k for k,v in comb_count.items() if ((v==max(comb_count.values())) and v >= 2)]
        answer.extend(max_order)
    answer = sorted(answer)
    return answer

from itertools import combinations
from collections import Counter
def anotherSolution(orders, course):
    answer = []
    for k in course:
        candidates = []
        for menu_li in orders:
            for li in combinations(menu_li, k):
                res = ''.join(sorted(li))
                candidates.append(res)
        sorted_candidates = Counter(candidates).most_common()
        answer += [menu for menu, cnt in sorted_candidates if cnt >1 and cnt == sorted_candidates[0][1]]
    return sorted(answer)


# ["AC", "ACDE", "BCFG", "CDE"]
print(anotherSolution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))

# ["ACD", "AD", "ADE", "CD", "XYZ"]
# print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5]))

# ["WX", "XY"]
# print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))