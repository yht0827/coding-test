# U : 위, D : 아래, R : 오른쪽, L : 왼쪽
# 처음 걸어본 길의 길이를 구한다
# 좌표를 벗어난 명령은 무시

def solution(dirs):
    width = 0
    length = 0
    answer = 0
    width_dir = [[0 for i in range(10)] for j in range(10)]
    length_dir = [[0 for i in range(10)] for j in range(10)]

    for cmd in dirs:
        if cmd == "U" and length < 5:
            length += 1
        elif cmd == "D" and length > -5:
            length -= 1
        elif cmd == "L" and width > -5:
            width -= 1
        elif cmd == "R" and length < 5:
            width += 1
        else:
            continue

        if (cmd == "U" or cmd == "D") and length_dir[width][length] != 1:
            length_dir[width][length] = 1
            answer += 1
        elif (cmd == "L" or cmd == "R") and width_dir[width][length] != 1:
            width_dir[width][length] = 1
            answer += 1    
          
    return answer

print(solution("UDLRDURL"))