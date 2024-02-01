
def solution(players, callings):

    player_rank = {}
    for i, player in enumerate(players):
        player_rank[player] = i
    
    for name in callings:
        idx = player_rank.get(name)
        front_player = players[idx - 1]
        
        
        player_rank[name] = idx - 1
        player_rank[front_player] = idx
        
        players[idx - 1] = name      
        players[idx] = front_player

    return players