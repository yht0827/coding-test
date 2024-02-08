def vietnam(floor, orig, dest):
    result = []
    mid = 6 - orig - dest
    if (floor > 1):
        result += vietnam(floor-1, orig, mid)
        result += [[orig, dest]]
        result += vietnam(floor-1, mid, dest)
        return result
    else:
        return [[orig, dest]]

def solution(n):
    return vietnam(n, 1, 3)