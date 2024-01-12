# 처음에는 배열로 접근을 했는데 효율성 5번에서 문제가 발생
# 배열보다 접근 속도가 빠른 딕셔너리로 형 변환을 해줘서 해결

def solution(participant, completion):
    
    if len(participant) == 1:
        return participant[0]
    
    if len(set(participant)) - len(set(completion)) == 1:
        answer = list(set(participant) - set(completion))
        return answer[0]
    
    participant.sort()
    participant_di = {i : participant[i] for i in range(len(participant))}
    
    completion.sort()
    completion_di = {i : completion[i] for i in range(len(completion))}
    
    for key, value in completion_di.items():
        if value != participant_di[key]:
            return participant_di[key]
        
    return participant[-1]

print(solution(["mislav", "stanko", "mislav", "ana"],	["stanko", "ana", "mislav"]))