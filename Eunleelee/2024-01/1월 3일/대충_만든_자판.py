def solution(keymap, targets):
    answer = []
    alphabet = {}  # 자판에 있는 알파벳들을 몇 번 눌러야 하는지 저장
    for key in keymap:
        for i in range(len(key)):
            if key[i] not in alphabet:
                alphabet[key[i]] = i + 1
            else:
                if alphabet[key[i]] > i + 1:
                    alphabet[key[i]] = i + 1

    for word in targets:
        push = 0  # 누르는 횟수
        for char in word:
            if char in alphabet:
                push += alphabet[char]
            else:
                push = -1 
                break
            
        answer.append(push)
    return answer

print(solution(["ABACD", "BCEFD"],["ZBCD","AABB"]))