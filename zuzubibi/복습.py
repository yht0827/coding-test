def solution(new_id):
    for _ in range(2):
        # 1단계
        new_id = new_id.lower()
        # 2단계
        new_id = ''.join([ i for i in new_id if i.isalnum() or i =="-" or i == '_' or i == '.'])
        # 3단계
        new_id = new_id.replace("....", ".")
        new_id = new_id.replace("...", ".")
        new_id = new_id.replace("..", ".")
        # 4단계
        if len(new_id) >= 2 and new_id[0] == '.' :
            new_id = new_id[1:]
        elif len(new_id) >= 2 and new_id[-1] == '.':
            new_id = new_id[:-1]
        elif len(new_id) <= 1 and new_id[-1] == '.':
            new_id = ''

        # 5단계
        if len(new_id) == 0:
            new_id += 'a'
        # 6단계
        if len(new_id)>=16:
            new_id = new_id[:15]
        # 7단계
        if len(new_id)<=2:
            while True:
                if len(new_id) == 3:
                    break
                new_id += new_id[-1]
    
    return new_id