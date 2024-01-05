def solution(s):
    answer = ''
    # 숫자 영어를 배열로 저장
    number_en = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    number = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    u = ''  # 문자열을 저장하는 변수
    
    for i in s:
        u += i  # 문자열 s에서 한글자씩 문자열 u에 추가 
        if u in number_en:  
            answer += str(number_en.index(u))  # 문자로된 숫자를 인덱스번호로 숫자로 변환
            u = ''
        elif u in number:
            answer += str(u)  # 숫자가 있으면 그대로 문자열로 변환
            u = ''
    
    answer = int(answer)

    return answer