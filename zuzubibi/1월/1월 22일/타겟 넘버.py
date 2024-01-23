def bfs(numbers, target):
    leaves = [0]
    # count = 0

    for num in numbers:
        temp= []

        # 자손 노드
        for leaf in leaves:
            temp.append(leaf + num)
            temp.append(leaf - num)
        leaves = temp

    # print(leaves.count(target))
    # for leaf in leaves:
    #     if leaf == target:
    #         count += 1
    return leaves.count(target)

def dfs(numbers, target):
    if not numbers and target == 0:
        return 1
    elif not numbers:
        return 0
    else:
        return dfs(numbers[1:], target-numbers[0]) + dfs(numbers[1:], target+numbers[0])

from itertools import product
def anotherSolution(numbers, target):
    l = [(x,-x) for x in numbers]
    s = list(map(sum, product(*l)))
    print(s)
    return s.count(target)


print(anotherSolution([1, 1, 1, 1, 1],3)) # 5
print(anotherSolution([4, 1, 2, 1], 4)) # 2