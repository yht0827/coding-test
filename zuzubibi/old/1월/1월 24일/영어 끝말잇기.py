def solution(n, words):
    num, turn = 0,0
    arr = set()

    for i in range(1, len(words)):
        num += 1
        if n < num:
            num = 1
            turn += 1

        # print(words[i-1], words[i], words[i-1][-1], words[i][0])
        if words[i-1][-1] != words[i][0]:
            return [num,turn]

        if words[i-1] not in arr:
            arr.add(words[i-1])
        else:
            turn += 1
            return [num, turn]
        print(num, turn)
    num += 1
    if n < num:
        num = 1
        turn += 1
    if words[-1] not in arr:
        arr.add(words[-1])
    else:
        turn += 1
        return [num, turn]
    print(num, turn)
    return [0,0]

#--------------------------------------------------------------------------------
def anotherSolution(n, words):
    used_words = []
    number, order = 0,0

    used_words.append(words[0])
    last_word = words[0][-1]
    for i in range(1, len(words)):
        if words[i] not in used_words and words[i][0] == last_word:
            used_words.append(words[i])
            last_word = words[i][-1]
        else:
            number = (i%n)+1
            order = (i//n)+1
            break
    return [number, order]

#-------------------------------------------------------------------------------

def anotherSolution2(n, words):
    for p in range(1, len(words)):
        if words[p][0] != words[p-1][-1] or words[p] in words[:p]: 
            return [(p%n)+1, (p//n)+1]
    else:
        return [0,0]



# [3,3]
print(anotherSolution2(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))
# [0,0]
print(anotherSolution2(5, ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]))
# [1,3]
print(anotherSolution2(2, ["hello", "one", "even", "never", "now", "world", "draw"]))