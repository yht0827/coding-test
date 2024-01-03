# 문제 핵심
# 1. set을 이용한 중복 제거 
# 2. %로 알파벳 순환 

# 새롭게 안 것
# 1. from string import ascii_lowercase

# ----------------------------------------------------------------
def others(s, skip, index):
    alps = sorted(set("abcdefghijklmnopqrstuvwxyz") - set(skip))

    alps_num = len(alps)
    result = ''

    for char in s:
        result += alps[(alps.index(char)+ index) % alps_num]
    
    return result

# ------------------------------------------------------------------

from string import ascii_lowercase

def solution(s, skip, index):
    result = ''

    a_to_z = set(ascii_lowercase)
    a_to_z -= set(skip)
    a_to_z = sorted(a_to_z)
    l = len(a_to_z)

    dic_alpha = {alpha:idx for idx, alpha in enumerate(a_to_z)}
    print(dic_alpha)

    for i in s:
        result += a_to_z[(dic_alpha[i] + index) % l]

    return result

#---------------------------------------------------------------------
from string import ascii_lowercase
def remind(s, skip, index):
    arr = set(ascii_lowercase)
    arr -= set(skip)
    arr = sorted(arr)
    l = len(arr)
    result = ''

    for i in s:
        result += arr[(arr.index(i)+index)% l]
    return result







# s = "aukks"
# skip = "wbqd"
# index = 5
# re = solution2(s, skip, index)  # result: "happy"
# print(re)

s = 'ybcde'
skip = 'az'
index = 1
print(solution(s,skip,index)) # result: bcdef


# s = "yyyy"
# skip = 'za'
# index = 2
# print(solution2(s, skip, index))  # result: ccccc