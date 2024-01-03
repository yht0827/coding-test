def dist(src, dst):
    position = {
        '*': (3,0),
        '#': (3,2),
        '1': (0,0),
        '2': (0,1),
        '3': (0,2),
        '4': (1,0),
        '5': (1,1),
        '6': (1,2),
        '7': (2,0),
        '8': (2,1),
        '9': (2,2),
        '0': (3,1),
    }
    srcpos = position[src]
    dstpos = position[dst]
    return abs(srcpos[0]- dstpos[0]) + abs(srcpos[1]-dstpos[1])

def solution(numbers, hand):
    numbers = [str(x) for x in numbers]
    left, right = '*', '#'
    answer = []
    for x in numbers:
        if x in '147':
            answer.append('L')
            left = x
        elif x in '369':
            answer.append('R')
            right = x
        else:
            if dist(left, x) < dist(right, x):
                answer.append('L')
                left = x
            elif dist(right, x) < dist(left, x):
                answer.append('R')
                right = x
            else:
                if hand == 'left':
                    answer.append('L')
                    left = x
                else:
                    answer.append('R')
                    right = x
    return ''.join(answer)