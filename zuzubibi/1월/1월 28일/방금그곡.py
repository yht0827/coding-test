def time_c(t):
    return int(t.split(':')[0])*60 + int(t.split(':')[1])

def chagne(x):
    exc = {'C#':'1', 'D#':'2', 'F#':'3', 'G#':'4', 'A#': '5'}
    for k,v in exc.items():
        x = x.replace(k,v)
    return x

def solution(m, musicinfos):
    answer = []
    for musicinfo in musicinfos:
        info = musicinfo.split(",")
        info[3] = chagne(info[3])
        T = time_c(info[1]) - time_c(info[0])

        # code의 길이 만큼 반복
        if T >= len(info[3]):
            M = info[3] * (T//len(info[3])) + info[3][:T%len(info[3])]
        else:
            M = info[3][:T]

        # 만약 m이 code와 겹친다면 answer에 제목 저장
        if chagne(m) in M:
            answer.append([T, info[2]])
        
    # 일치하는 것이 없다면 '(None)' 반환
    if len(answer) == 0:
        return '(None)'
    else:
        return sorted(answer, key=lambda x : -x[0])[0][1]
    
    
    
# "HELLO"
print(solution("ABCDEFG",["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))

# "FOO"
print(solution("CC#BCC#BCC#BCC#B",["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]))

# "WORLD"
print(solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]))
