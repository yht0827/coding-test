def solution(p):
    if not p : return p

    r,c = True, 0
    for i in range(len(p)):
        if p[i] == '(': c -= 1
        else: c += 1

        if c >0: r = False
        if c == 0:
            if r: return p[:i+1] + solution(p[i+1:])
            else:
                return '(' + solution(p[i+1:]) + ')' + ''.join(list(map(lambda x: '(' if x ==')' else ')', p[1:i])))


print(solution("(()())()")) # "(()())()"
print(solution(")(")) # "()"
print(solution("()))((()")) # "()(())()"