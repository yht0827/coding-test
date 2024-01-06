def solution(board, moves):
    stack = [0]
    result = 0

    for move in moves:
        isPicked = False
        for j in range(len(board)):         
            
            if isPicked or board[j][move-1] == 0:
                continue
            else:
                if board[j][move-1] == stack[-1]:
                    stack.pop(-1)
                    result +=2

                else:
                    stack.append(board[j][move-1])
                board[j][move-1] = 0
                isPicked = True

    return result




board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves = [1,5,3,5,1,2,1,4]

print(solution(board, moves)) # 4