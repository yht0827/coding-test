def solution(today, terms, privacies):
    answer = []
    today = list(map(int, today.split('.')))  # 오늘 날짜를 저장하는 배열
    term = dict() # 약관을 딕셔너리로 저장 [알파벳, 개월 수]
    for period in terms:
        period = period.split(' ')
        term[period[0]] = int(period[1])

    for i, privacy in enumerate(privacies):
        expire = list(map(int, privacy[:10].split('.')))  # 만료 날짜를 저장하는 배열
        privacy_term = privacy[-1]  # 개인 약관을 저장하는 변수

        if expire[1] + term[privacy_term] > 12:  # 만료 월과 약관 개월수를 더할 때, 12개월 초과이면
            if term[privacy_term] >= 12:  # 만료 월 + 약관 개월 수가 12의 배수일 수도 있음을 고려
                expire[0] += term[privacy_term] // 12
                expire[1] += term[privacy_term] % 12
                if expire[1] > 12:
                    expire[0] += expire[1] // 12
                    expire[1] = expire[1] % 12
            else:
                expire[0] += (expire[1] + term[privacy_term]) // 12
                expire[1] = (expire[1] + term[privacy_term]) % 12
        else:
            expire[1] += term[privacy_term]
        
        if today[0] > expire[0]:  # 현재 연도가 만료 연도보다 지났다면
            answer.append(i+1)
        elif today[0] == expire[0] and today[1] > expire[1]: # 현재 월이 만료 월보다 지났다면
            answer.append(i+1)
        elif today[0] == expire[0] and today[1] == expire[1] and today[2] >= expire[2]:  # 현재 일수가 만료 일수와 같거나 지났다면
            answer.append(i+1)

    return answer

print(solution2("2009.12.31", ["A 13"], ["2008.11.03 A"]))