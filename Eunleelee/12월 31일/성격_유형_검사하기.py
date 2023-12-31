def solution(survey, choices):
    answer = ''

    # 검사에 따른 결과를 test_di에 저장
    test_di = {"R" : 0, "T" : 0, "C" : 0, "F" : 0, "J" : 0, "M" : 0, "A" : 0, "N" : 0}
    
    # 짝지어 지는 원소끼리 나열, 사전순으로 나열
    test = ["R", "T", "C", "F", "J", "M", "A", "N"]
    
    for i in range(len(survey)):
        survey_list = list(survey[i]) 

        # 선택을 한 숫자가 4 미만이라면 survey[i]에 첫번째 유형에 1이 3점, 2가 2점, 3이 1점으로 배정 
        if choices[i] < 4:
            if choices[i] == 3:
                test_di[survey_list[0]] = test_di[survey_list[0]] + choices[i] - 2
            elif choices[i] == 2:
                test_di[survey_list[0]] = test_di[survey_list[0]] + choices[i]
            elif choices[i] == 1:
                test_di[survey_list[0]] = test_di[survey_list[0]] + choices[i] + 2

        # 선택을 한 숫자가 4 초과라면 survey[i]에 두번째 유형에 1이 1점, 2가 2점, 3이 3점으로 배정 
        elif choices[i] > 4:
            test_di[survey_list[1]] = test_di[survey_list[1]] + choices[i] - 4
    
    num = 0
    # i와 i+1을 비교해서 더 큰 것을 answer에 저장, 같다면 앞에 겉을 저장
    for i in range(4):
        if test_di[test[num]] < test_di[test[num+1]]:
            answer += test[num+1]
        elif test_di[test[num]] > test_di[test[num+1]]:
            answer += test[num]
        elif test_di[test[num]] == test_di[test[num+1]]:
            answer += test[num]
        num += 2
    return answer