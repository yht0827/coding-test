def solution(s, skip, index):
    alphabet = 'abcdefghijklmnopqrstuvwxyz' # 모든 알파벳을 alphabet 문자열에 저장
    answer = ''

    # 뛰어넘을 문자들을 alphabet 문자열에서 제거
    for i in skip:
        alphabet = alphabet.replace(i, '')

    alphabet_len = len(alphabet)  # skip 문자열이 제거된 alphabet 문자열에 길이
    num = 0

    for word in s:
        num = alphabet.find(word)  # 변환해야 할 문자를 alphabet 문자열에서 인덱스를 찾아 num에 저장
        
        # 구해야 하는 문자가 alphabet의 길이를 초과하면 num + index 값에서 alphabet의 길이를 나눈 값의 
        # 나머지를 인덱스로 정해서 answer에 저장
        if num + index > alphabet_len - 1:
            answer += alphabet[(num + index) % alphabet_len]
        
        # 그게 아니라면 alphabet에서 num + index의 인덱스 값으로 answer에 저장
        else:
            answer += alphabet[num + index]
                
    return answer

print(solution( "zzzzzz", "abcdefghijklmnopqrstuvwxy", 6))