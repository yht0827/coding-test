#딕셔너리 이용해서 풀어야함

def solution(players, callings):
    answer = []
    dic_players = {}
    dic_lank = {}
    
    for idx, i in enumerate(players):
        dic_players[i] = idx
        dic_lank[idx] = i
    
    for i in callings:
        cur_idx = dic_players[i]
        
        dic_players[i] = cur_idx - 1
        dic_players[dic_lank[cur_idx-1]] = cur_idx
        
        dic_lank[cur_idx] = dic_lank[cur_idx - 1]
        dic_lank[cur_idx - 1] = i
    
    answer = list(dic_lank.values())
             
    return answer