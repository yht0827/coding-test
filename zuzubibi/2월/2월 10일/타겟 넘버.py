def solution(num, tar):
    leaves = [0]

    for n in num:
        temp = []

        for lef in leaves:
            temp.append(lef + n)
            temp.append(lef - n)
        leaves = temp
    
    print(leaves)
    return leaves.count(tar)

print(solution([1, 1, 1, 1, 1],3))
print(solution([4, 1, 2, 1],4))