def solution(park, routes):
    r,c,R,C = 0,0,len(park),len(park[0]) # r,c : S위치 / R,C : 보드경계
    move = {"E":(0,1),"W":(0,-1),"S":(1,0),"N":(-1,0)}
    for i,row in enumerate(park): # 시작점 찾기
        if "S" in row:
            r,c = i,row.find("S")
            break

    for route in routes:
        dr,dc = move[route[0]] # 입력받는 route의 움직임 방향
        new_r,new_c = r,c # new_r,new_c : route 적용 후 위치
        for _ in range(int(route[2])): 
            # 한칸씩 움직이면서, 보드 안쪽이고 "X"가 아니라면 한칸이동
            if 0<=new_r+dr<R and 0<=new_c+dc<C and park[new_r+dr][new_c+dc] != "X":
                new_r,new_c = new_r+dr,new_c+dc
            else: # 아니라면 처음 위치로
                new_r,new_c = r,c
                break
        r,c = new_r,new_c # 위치 업데이트

    return [r,c]

print(solution(["OSO","OOO","OXO","OOO"],	["E 2","S 3","W 1"]))