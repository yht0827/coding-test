def solution(s):
    arr = {'zero': "0", 'one':"1", 'two': "2", 'three':"3", 'four':"4", 'five':"5", 'six':"6", 'seven':"7", 'eight': "8", 'nine': "9"}
    result = ''
    stack = ''
    for i in s:
        if i.isdigit():
            result += str(i)
        else:
            stack += i
            if stack in arr.keys():
                result += arr[stack]
                stack = ''

    return int(result)
#=============================================================================
num_dic = {'zero': "0", 'one':"1", 'two': "2", 'three':"3", 'four':"4", 'five':"5", 'six':"6", 'seven':"7", 'eight': "8", 'nine': "9"}
def otherssolution(s):
    answer = s
    for k, v in num_dic.items():
        answer = answer.replace(k, v)
    return int(answer)

print(otherssolution("one4seveneight")) # 1478 
print(otherssolution("23four5six7")) # 234567
print(otherssolution("2three45sixseven")) # 234567
print(otherssolution("123")) # 123
