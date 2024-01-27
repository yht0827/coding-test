def iswhere(x):
    if x == 'code':
        return 0
    elif x == 'date':
        return 1
    elif x == 'maximum':
        return 2
    else:
        return 3
    
def solution(data, ext, val_ext, sort_by):
    # data에서 ext값이 val_ext보다 작은 데이터만 뽑기
    target = [i for i in data if i[iswhere(ext)] < val_ext]

    # 정보를 정렬할 기준이 되는 문자열
    target.sort(key = lambda x: x[iswhere(sort_by)])

    return target


#[[3,20300401,10,8],[1,20300104,100,80]]
print(solution([[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]],"date", 20300501,"remain"))