def solution(s):
    s = s.replace(" ", "")
    stack = []

    for i in s:
        if len(stack)==0:
            stack.append(i)
        elif stack[-1] ==i:
            stack.pop()
        else:
            stack.append(i)
    
    return 1 if len(stack)==0 else 0

print(solution("baabaa")) # 1
print(solution('cdcd')) # 0