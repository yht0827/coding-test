from collections import deque

def solution(order):
    order = deque(order)
    
    # main container work list
    main_line = deque(range(order[0], len(order)+1))
    # sub container work list
    sub_line = list(range(1, order[0]))

    print(main_line, sub_line)
    cnt = 0
    flag = True

    while flag and order:
        order_now = order.popleft()
        while True:
            if main_line and main_line[0] == order_now:
                main_line.popleft()
                cnt += 1
                break
            if sub_line and sub_line[-1] == order_now:
                sub_line.pop()
                cnt += 1
                break
            
            if not main_line:
                flag = False
                break
            else:
                sub_line.append(main_line.popleft())
    return cnt


def anotherSolution(order):
    assist = []
    i = 1
    cnt = 0
    while i != len(order)+1:
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt += 1
            assist.pop()
        i+=1
    return cnt

def same1(order):
    assist = []
    cnt = 0
    i = 1
    while i != len(order)+1:
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt += 1
            assist.pop()
        i+= 1
    return cnt


def same2(order):
    assist = []
    i =1
    cnt = 0
    while i != len(order)+1:
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt += 1
            assist.pop()
        i+=1
    return cnt

def same3(order):
    assist = []
    i = 1
    cnt = 0
    while i != len(order)+1:
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt += 1
            assist.pop()
        i += 1
    return cnt

def same4(order):
    assist = []
    cnt = 0
    i= 1
    while i != len(order)+1:
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt += 1
            assist.pop()
        i += 1
    return cnt

def same5(order):
    assist = []
    i = 1
    cnt = 0
    while i != len(order)+1:
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt -= 1
            assist.pop()
        i += 1
    return cnt

print(same3([4, 3, 1, 2, 5])) # 2
print(same3([5, 4, 3, 2, 1])) # 5