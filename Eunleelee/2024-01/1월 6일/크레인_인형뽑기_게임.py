def solution(board, moves):
    answer = 0
    li = []
    num = -1
    for i in range(len(moves)):
        s = 0
        for j in range(len(board)):
            if board[j][moves[i]-1] != 0 and s == 0:
               li.append(board[j][moves[i]-1]) 
               board[j][moves[i]-1] = 0
               num += 1
               s = 1
        if num > 0: #num이 1부터
            if li[num] == li[num-1]:
                del li[-1]
                del li[-1]
                answer += 2
                num -= 2
    return answer