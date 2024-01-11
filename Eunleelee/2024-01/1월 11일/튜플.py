def solution(s):
    answer = []
    # 문자열 s를 정리해서 리스트로 변환
    s = s[0:-2]
    s = s.replace("{", "")
    s = s.replace(",", " ")
    s = s.split('} ')
    s.sort(key=len)  # 길이 순으로 정렬

    for i in s:
        if not answer: # 길이가 1일때 
            answer.append(int(i))
        else:
            # 현재 있는 숫자와 주워진 숫자를 비교해서 추가된 숫자를 answer에 추가
            now = set(map(int, i.split(' ')))
            pre = set(answer)
            a = list(now - pre)
            answer.append(a[0])
    
    return answer

print(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))