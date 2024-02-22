def solution(a,b):
    # 1월 1일이 금요일이므로 7로 나눴을 때 인덱스 1이 금요일로 나오게 설정
    day = ['THU', 'FRI', 'SAT', 'SUN', 'MON', 'TUE','WED']

    # 각 달의 날짜만큼 배열로 저장
    mon = [31,29,31,30,31,30,31,31,30,31,30,31]

    # mon 배열의 (a-1)월까지 더한 수에 날짜 다 더한 수
    # 구하고자하는 b 날짜를 더하고 7로 나눈 나머지의 인덱스에 해당하는 수 반환
    return day[(sum(mon[:a-1]) +b)%7]

import datetime
def anotherSolution(a,b):
    t = 'MON,TUE,WED,THU,FRI,SAT,SUN'.split(',')
    return t[datetime.datetime(2016,a,b).weekday()]

print(anotherSolution(5,24)) # 'TUE'
print(anotherSolution(2,29)) # 'MON'

# ---------------------datetime라이브러리 공부 ------------------------------------------------
x = datetime.datetime.now()
print(x)
print(x.year)
print(x.month)
print(x.day)
print(x.hour)
print(x.minute)
print(x.second)
print(x.microsecond)

print(x.weekday())
print(x.strftime("%Y %m %d %H %M %S %A %B"))
print(x.strftime("%A %d. %B %Y"))
print(x.strftime("%H시 %M분 %S초"))

print(datetime.datetime.strptime("2021-01-01 14:44", "%Y-%m-%d %H:%M"))

# print(x.strftime("%Y %m %d %H %M %s %A %B"))

from dateutil.parser import parse
print(parse('2016-04-16'))
print(parse("Apr 16, 2016 04:05:32 PM"))
print(parse('6/7/2021'))

dt1 = datetime.datetime(2016,2,19,14)
dt2 = datetime.datetime(2016,1,2,13)
td = dt1 - dt2
print(td)
print(td.days)
print(td.seconds // 60)
