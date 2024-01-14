def solution(s):
    # 압축 단위 후보
    candi = [i for i in range(1, (len(s)//2+1))]
    # 정답의 upper bound는 압축을 하지 않은 케이스
    answer = len(s)

    # 각 압축단위에 대해서
    for length in candi:
        key = s[:length]
        shorten = []
        cnt = 1
        # 압축단위로 잘라서 압축을 진행하고
        # shorten에 압축문자열과 그 횟수를 저장한다.
        for i in range(length, len(s), length):
            if key == s[i: i+length]:
                cnt += 1
            else:
                shorten.append([key,cnt])
                cnt = 1
                key = s[i:i+length]
        shorten.append([key, cnt])

        # 기존의 베스트 압축길이와 새로운 압축길이를 비교해 업데이트
        # 문자열의 길이는 항상 포함하되, 압축횟수의 길이는 압축횟수가 2이상일 때만
        answer = min(answer, sum([len(key) + (len(str(cnt)) if cnt > 1 else 0) for key, cnt in shorten]))
    return answer

print(solution("aabbaccc")) # 7
print(solution("ababcdcdababcdcd")) # 9
print(solution("abcabcdede")) # 8
print(solution("abcabcabcabcdededededede")) # 14
print(solution("xababcdcdababcdcd")) # 17