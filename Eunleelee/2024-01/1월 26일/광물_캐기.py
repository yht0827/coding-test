def solution(picks, minerals):
    fatigue = 0
    dia_num, iron_num, stone_num = picks
    
    dia_fatigue = {"diamond" : 1, "iron" : 1, "stone" : 1}
    iron_fatigue = {"diamond" : 5, "iron" : 1, "stone" : 1}
    stone_fatigue = {"diamond" : 25, "iron" : 5, "stone" : 1}
    
    if sum(picks) * 5 < len(minerals):
        minerals = minerals[:sum(picks) * 5]
    
    minerals = [minerals[i:i+5] for i in range(0, len(minerals), 5)]
    minerals.sort(key = lambda m : (m.count("diamond"), m.count("iron"), m.count("stone")), reverse=True)
    
    for mineral in minerals:
        if dia_num == 0 and iron_num == 0 and stone_num == 0:
            break
        
        if dia_num > 0:
            for i in mineral:
                fatigue += dia_fatigue[i]
            dia_num -= 1
        
        elif iron_num > 0:
            for i in mineral:
                fatigue += iron_fatigue[i]
            iron_num -= 1
        
        elif stone_num > 0:
            for i in mineral:
                fatigue += stone_fatigue[i]
            stone_num -= 1
    
    return fatigue