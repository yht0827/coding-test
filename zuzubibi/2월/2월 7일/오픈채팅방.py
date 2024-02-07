
# 코딩을 할 때 목적을 나눠서 해야함을 느꼈다..
# id 최종 수정을 받는 함수, 행동변화에 따라 id값을 넣은 리스트 작성 함수 

def solution(record):
    id_list = {}
    move = []

    for info in record:
        type, data = info.split(' ')[0], info.split(' ')[1:]
        if type == 'Enter':
            id, name = data
            id_list[id] = name
            move.append((id, 'E'))

        elif type == 'Leave':
            del id_list[data[0]]
            move.append((data[0], 'L'))

        elif type=='Change' and id in id_list.keys():
            id, name = data
            id_list[id] = name
        # print(id_list)
        # print(move)
        # print()
    return  [ f'{id_list[id]}님이 들어왔습니다.' if t=='E' else f'{id_list[id]}님이 나갔습니다.' for id, t in move]
#------------------------------------------------------------------------------------------------------------------------
def anotherSolution(record):
    answer = []
    dic = {}

    for sentence in record:
        sentence_split = sentence.split()
        if len(sentence_split) == 3:  # Enter, Change만 걸러진다. = 정보 변경
            dic[sentence_split[1]] = sentence_split[2]
    # print(dic) # 즉, 최종 변경된 id와 name만 깔끔하게 정리 됨

    for sentence in record: # Enter와 Leave만 걸러진다. = 행동 관찰
        sentence_split = sentence.split()
        if sentence_split[0] == 'Enter':
            answer.append('%s님이 들어왔습니다.' %dic[sentence_split[1]])
        elif sentence_split[0] == 'Leave':
            answer.append('%s님이 나갔습니다.' %dic[sentence_split[1]])
    return answer

def anotherSolution2(record):
    answer = []
    namespace = {}
    printer = {'Enter': '님이 들어왔습니다.', 'Leave': '님이 나갔습니다.'}
    for r in record:
        rr = r.split(' ')
        if rr[0] in ['Enter', 'Change']:
            namespace[rr[1]] = rr[2]
    
    for r in record:
        if r.split(' ')[0] != 'Change':
            answer.append(namespace[r.split(' ')[1]] + printer[r.split(' ')[0]])
    return answer

# ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
print(anotherSolution2(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))