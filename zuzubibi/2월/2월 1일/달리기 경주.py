def solution(players, callings):
    answer = []
    turns = {}
    cnt = 1
    for i in range(len(callings)):
        if callings[i-1] == callings[i]:
            print(callings[i], cnt)
            cnt += 1
        else:
            print(callings[i], cnt)
            turns[callings[i]] = cnt
            cnt = 1
    
    print(turns)        
        # inx = players.index(calling)
        # players[inx-1],players[inx] = players[inx], players[inx-1]
    
    # answer = players
    # 음.. 더 고민해야겠다..
    return answer


# ["mumu", "kai", "mine", "soe", "poe"]
print(solution(["mumu", "soe", "poe", "kai", "mine"],["kai", "kai", "mine", "mine"]))