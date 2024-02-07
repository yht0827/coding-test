def solution(record):
    answer = []
    id_list = {}
    for i in range(len(record)):
        a = record[i].split(' ')
        if a[0] == "Enter" or a[0] == "Change":
            id_list[a[1]] = a[2]

    for i in range(len(record)):
        a = record[i].split(' ')
        if a[0] == "Enter":
            answer.append("{}님이 들어왔습니다.".format(id_list[a[1]]))
        elif a[0] == "Leave":
            answer.append("{}님이 나갔습니다.".format(id_list[a[1]]))
    
    return answer