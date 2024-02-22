from itertools import permutations
def solution(babbling):
    count = 0

    basic_babblings = ['aya', 'ye','woo','ma']
    all_babbling = []
    for i in range(1,5):
        perms = list(permutations(basic_babblings, i))
        # print(perms)
        for perm in perms:
            s = ''
            for element in perm:
                s += element
            all_babbling.append(s)
            
    for babblings in all_babbling:
        for babble in babbling:
            if babble == babblings:
                count += 1
    return count


# 1
print(solution(["aya", "yee", "u", "maa", "wyeoo"]))

# 3
print(solution(["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]))
