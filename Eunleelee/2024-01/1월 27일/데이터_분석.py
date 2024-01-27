def solution(data, ext, val_ext, sort_by):
    index = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    ext_index = index[ext]  # 정보의 배열 인덱스 값
    sort_index = index[sort_by]  # 정렬 기준 배열 인덱스 값
    
    new_data = []
    
    for d in data:
        if d[ext_index] < val_ext:
            new_data.append(d)
    
    answer = sorted(new_data, key = lambda x : x[sort_index])

    return answer