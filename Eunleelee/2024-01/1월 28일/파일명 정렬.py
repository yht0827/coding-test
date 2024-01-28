def solution(files):
    answer = []
    for file in files:
        length = len(file)

        head_idx = 0
        while head_idx < length:
            try:
                int(file[head_idx])
                break
            except:
                head_idx += 1

        number_idx = head_idx
        while number_idx < length:
            try:
                int(file[number_idx])
                number_idx += 1
            except:
                break

        head = file[:head_idx]
        number = file[head_idx:number_idx]
        if number_idx == length:
            tail = ""
        else:
            tail = file[number_idx:]

        answer.append([head, number, tail, file])

    answer = sorted(answer, key=lambda x: (x[0].lower(), int(x[1])))
    answer = [x[3] for x in answer]
    return answer