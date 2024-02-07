# 문제 전략
# 그대로 구현
# 다른 사람의 답을 보니, 배열 그대로 유지하지 않고 숫자를 다 곱해서 구하면 더 빠르게 구할 수 있음
# -------------------------------------------------------------------
def diff(a, today, ter_day):
    # 오는 날
    yyyy, mm, dd = map(int, today.split('.'))
    # 개인 정보 수집 일
    info_y, info_m, info_d = map(int, a.split('.'))
    info_d += ter_day*28 -1
    # 날짜 계산
    if info_d > 28:
        info_m += info_d//28
        info_d = (info_d)%28
        if info_d == 0:
            info_d = 28
            info_m -= 1
    if info_m > 12:
        info_y += info_m//12
        info_m = info_m%12
        if info_m == 0:
            info_m = 12
            info_y -=1


    # 오는 날보다 파기 일이 작다면, 파기 대상
    if yyyy > info_y:
        return True
    elif yyyy == info_y and mm > info_m:
        return True
    elif yyyy == info_y and mm == info_m and dd > info_d:
        return True
    # 오는 날보다 파기 일이 크다면, 대기
    else:
        return False
 
# test case
# a = "2021.07.01"
# today = "2022.05.19"
# ter_day = 12
# print(diff(a,today, ter_day)) # True


def solution(today, terms, privacies):
    term_list = [[term.split(' ')[0], int(term.split(' ')[1])] for term in terms]
    result = []
    for index, info in enumerate(privacies):
        a, b = info.split(' ')

        # 약관 찾기
        for ter_ch, ter_day in term_list:
            if ter_ch == b:
                # 차이 계산하기
                    if diff(a, today, int(ter_day)):
                        result.append(index+1)         
                    else:
                        break
    result.sort()

    return result


# today="2022.05.19"
# terms = ["A 6", "B 12", "C 3"]
# privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
# print(solution(today, terms, privacies)) # [1,3]

# today = "2020.01.01"
# terms= ["Z 3", "D 5"]
# privacies = ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]
# print(solution(today, terms, privacies)) # [1,4,5]


# -----------------------------------------------------------------------------
def to_days(date): # 이거 유용하게 써먹구나 
    year, month, day = map(int, date.split("."))
    return year * 28 * 12 + month * 28 + day

def solution(today, terms, privacies):
    months = {v[0]: int(v[2:]) * 28 for v in terms}  # 딕셔너리 변태같이 잘 짰네
    today = to_days(today)
    expire = [
        i + 1 for i, privacy in enumerate(privacies)
        if to_days(privacy[:-2]) + months[privacy[-1]] <= today
    ]
    return expire

# 씨발