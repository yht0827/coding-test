def turns(n):
    result = ord(f'{n}') - ord('A')
    return result if result < 13 else minimum(result)

def minimum(n): 
    return 26-n

def solution(name):
    if len(name) == name.count('A'):
        return 0
    else:
        return sum([turns(i) for i in name]) + len(name) - name.count('A') - 1


#----------------------------------------------------------------------
def anotherSolution(name):
    # 조이스틱 조작 횟수
    answer = 0

    # 기본 최소 좌우이동 횟수는 길이 - 1
    min_move = len(name) -1

    for i, char in enumerate(name):
        # 해당 알파벳 변경 최솟값 추가
        answer += min(ord(char)-ord('A'), ord('Z')-ord(char)+1)

        # 해당 알바벳 다음부터 연속된 A 문자열 찾기
        next = i+1
        while next < len(name) and name[next] == 'A':
            next += 1

        # 기존, 연속된 A의 왼쪽시작 방식, 연속된 A의 오른쪽 시작 방식 비교 및 갱신
        min_move = min([min_move, 2*i+len(name)-next, i+2*(len(name)-next)])
       
    # 알파벳 변경(상하이동) 횟수에 좌우이동 횟수 추가
    answer += min_move
    return answer

# print(anotherSolution("JEROEN")) # 56
# print(anotherSolution("JAN")) # 23
print(anotherSolution('BCAAABCD'))
# print(anotherSolution('BCDAAABCD'))