def solution(s):
    result = ''
    if s == "":
        return ""
    for i in s.split(" "):
        if not i[0].isdigit():
            result += i[0].upper()
        else:
            result += i[0]
        for j in i[1:]:
            if j.isdigit():
                result += j
            else:
                result += j.lower()
        result += ' '
            
    return result.rstrip()

def solution(s):
    return ' '.join(list( i[0].upper()+i[1:].lower() if not i[0].isdigit() else i for i in s.split(" ")))

#---------------------------------------------------------------
def anotherSolution(s):
    answer = ''
    s = s.split(' ')
    for i in range(len(s)):
        s[i] = s[i].capitalize()
    answer = ' '.join(s)
    return answer

def anotherSolution2(s):
    # return s.title()
    return s

print(anotherSolution("3people unFollowed me")) # "3people Unfollowed Me"
print(anotherSolution2("for the last week")) # 	"For The Last Week"
print(anotherSolution(""))
print(anotherSolution2("a b"))