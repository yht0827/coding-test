# 문제 전략
# 그대로 구현
#-----------------------------------------------------------------
def solution(keymap, targets):
    result = []

    for target in targets:
        times = 0
        for i in target:
            lower = 9999
            for keys in keymap:
                if i in keys and keys.index(i) < lower:
                    lower = keys.index(i)+1
            if lower == 9999:
                times = -1
                break
            else:
                times += lower
        result.append(times)
        
    return result

print(solution(["ABACD", "BCEFD"],["ABCD","AABB"])) #[9, 4]
print(solution(["AA"], ["B"])) #[-1]
print(solution(["AGZ", "BSSS"], ["ASA","BGZ"])) #[4, 6]
print(solution(["ABC"], ["CXA", "C"]))