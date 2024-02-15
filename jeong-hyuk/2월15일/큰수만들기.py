def solution(number, k):
    stack = []
    
    for num in number:
        #스택에 숫자가 있고, 현재 숫자가 스택의 가장 위의 숫자보다 크고, 아직 제거해야 할 숫자가 남아있으면
        while stack and stack[-1] < num and k > 0:
            #스택의 가장 위의 숫자를 제거하고 k를 1 감소시킴
            stack.pop()
            k -= 1
        #현재 숫자를 스택에 추가
        stack.append(num)
    
    #만약 k가 0보다 크다면 남은 숫자들 중에서 뒤에서부터 k개를 제거함
    if k > 0:
        stack = stack[:-k]
    
    return ''.join(stack)