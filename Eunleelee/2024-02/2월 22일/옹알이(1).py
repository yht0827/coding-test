def solution(babbling):
    possible = ["aya", "ye", "woo", "ma"]
    answer = 0
    child = ''
    
    for sounds in babbling:
        child = ''
        for sound in sounds:
            child += sound
            if child in possible:
                child = ''
        if len(child) == 0:
            answer += 1
    return answer
