#1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
#2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
#3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
#4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
#5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
#6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
#     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
#7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.#

def solution(new_id):
    answer = ''
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    giho = '-_.'
    n ='1234567890'
    
    # 1단계 - 대문자에서 소문자로 치환
    new_id = new_id.lower()
    
    i = 0
    dot_count = 0
    while 1:
        if new_id[i] == ".":
            dot_count += 1

            # 3단계 - '.'이 2개라면 '..'을 '.'으로 치환
            if dot_count > 1:
                new_id = new_id.replace('..', '.')
                i = 0
                dot_count = 0
            else:
                i += 1
        # 2단계 - 알파벳 소문자, 허용된 기호, 숫자를 제외한 모든 문자 제거
        elif new_id[i] not in giho and new_id[i] not in alphabet and new_id[i] not in n:
            new_id = new_id.replace(new_id[i], '')
            dot_count = 0
            i -= 1
        else:
            i += 1
            dot_count = 0 
        
        # 확인한 문자가 마지막 문자라면 빠져나감
        if i == len(new_id):
            break
    
    if len(new_id) != 0:
        if new_id[0] == '.':  # 4단계 - 처음에 위치한 '.'은 제거
            new_id = new_id.lstrip('.')
    if len(new_id) != 0:
        if new_id[-1] == '.':  # 4단계 - 끝에 위치한 '.'은 제거
            new_id = new_id.rstrip('.')
    if len(new_id) == 0:  # 5단계 - 빈 문자열이면 최소 길이 3을 충족하기 위해 'aaa'로 지정
        new_id = 'aaa'
    if len(new_id) > 15:  # 6단계 - 16자 이상이면 15자만 허용
        new_id = new_id[:15]
    elif len(new_id) < 3:  # 7단계 - 2자 이하라면, 마지막 문자를 길이가 3이 될때까지 반복
        if len(new_id) == 1:
            new_id += new_id[-1] * 2
        elif len(new_id) == 2:
            new_id += new_id[-1]
    
    if new_id[-1] == '.':  # 6단계 - 15자만 허용할 때 마지막 문자가 '.'라면 '.'을 제거
        new_id = new_id.rstrip('.')

    return new_id