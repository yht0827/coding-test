def solution(book_time):
    # book_time 정렬
    book_time.sort() #[ ["14:10", "19:20"], ["14:20", "15:20"], ["15:00", "17:00"], ["16:40", "18:20"], ["18:20", "21:20"]]
    
    # 객실을 사용하는 곳에 종료 시간을 저장하는 배열
    rooms = []
    
    # 몇 개의 객실이 사용중인지 표시
    room_num = 0

    for i in book_time:
        start = list(map(int, i[0].split(':')))  # 대실 시작 시간을 start 배열에 '시'와 '분'으로 나눠서 저장
        end = list(map(int, i[1].split(':')))  # 대실 종료 시간을 start 배열에 '시'와 '분'으로 나눠서 저장
        
        # 처음에 대실을 시작하는 손님은 무조건 객실 추가
        if len(rooms) == 0:  
            rooms.append(end[0] * 60 + end[1] + 10)  # 종료 시간 + 청소시간 10분을 추가해서 저장
            room_num += 1
        else:
            ok = False  # 사용한 객실을 사용할 수 있는지 여부를 표시
            start_time = start[0] * 60 + start[1]
            for j in range(len(rooms)):
                # 사용한 객실을 사용할 수 있다면
                if rooms[j] <= start_time:
                    rooms[j] = end[0] * 60 + end[1] + 10
                    ok = True
                    break
            # 배정된 객실 중에 사용할 수 있는 객실이 없다면 객실을 추가
            if ok == False:
                rooms.append(end[0] * 60 + end[1] + 10)
                room_num += 1
    return room_num

print(solution([["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]))