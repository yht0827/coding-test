def solution(new_id):
    for _ in range(2):
        # 1단계
        new_id = new_id.lower()
        # 2단계
        new_id = ''.join([ i for i in new_id if i.isalnum() or i =="-" or i == '_' or i == '.'])
        # 3단계
        new_id = new_id.replace("......", ".")
        new_id = new_id.replace(".....", ".")
        new_id = new_id.replace("....", ".")
        new_id = new_id.replace('...', '.')
        new_id = new_id.replace('..', '.')
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


#-----------------------------------------------------------------
import re
def others(new_id):
    st = new_id
    st = st.lower()
    st = re.sub('[^a-z0-9\-_.]', "", st)
    st = re.sub('\.+', '.', st)
    st = re.sub('^[.]|[.]$', '', st)
    st = 'a' if len(st) == 0 else st[:15]
    st = re.sub('^[.]|[.]$', '', st)
    st = st if len(st) >2 else st + "".join([st[-1] for _ in range(3-len(st))])
    return st



print(solution("...!@BaT#*..y.abcdefghijklm")) #"bat.y.abcdefghi"
print(solution("z-+.^.")) # "z--"
print(solution("=.=")) #"aaa"
print(solution("123_.def")) #"123_.def"
print(solution("abcdefghijklmn.p")) #"abcdefghijklmn"
print(solution("a.$.a")) #a.a