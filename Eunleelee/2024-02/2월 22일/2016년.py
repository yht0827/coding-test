def solution(a, b):
    #1, 3, 5, 7, 8, 10, 12 - 31일
    # 2 - 28일
    #4, 6, 9, 11 - 30일
    answer = ''
    yoil = ['FRI','SAT', 'SUN', 'MON','TUE','WED','THU']
    day = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    x = 0
    for i in range(a-1): #5월이면 4월까지(0, 1, 2, 3)
        x += day[i]
    x = x + b
    x = x % 7
    answer = yoil[x-1]
    
        
    return answer
