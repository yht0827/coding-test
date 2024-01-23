from itertools import combinations
def solution(orders, course):
    answer = []

    for course_item in course:
        comb_count = {}
        # order_combinations = []

        max_order = []
        for order in orders:
            order_comb = combinations(list(order), course_item)

            for order in order_comb:
                order_comb_string = "".join(sorted(order))

                if comb_count.get(order_comb_string):
                    comb_count[order_comb_string] += 1
                
                else:
                    comb_count[order_comb_string] = 1
        max_order = [k for k,v in comb_count.items() if ((v==max(comb_count.values())) and v >= 2)]
        answer.extend(max_order)
        print(answer)
    answer = sorted(answer)
    return answer



# ["AC", "ACDE", "BCFG", "CDE"]
print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2,3,4]))

# ["ACD", "AD", "ADE", "CD", "XYZ"]
print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2,3,5]))

# ["WX", "XY"]
print(solution(["XYZ", "XWY", "WXA"], [2,3,4]))