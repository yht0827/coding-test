def solution(wallpaper):
    answer = []
    lux, luy, rdx, rdy = 100, 100, -1, -1
    
    for i, folder in enumerate(wallpaper):
        for j, file in enumerate(folder):
            if file == "#":
                if i < lux:
                    lux = i
                if j < luy:
                    luy = j
                if i > rdx:
                    rdx = i
                if j > rdy:
                    rdy = j
    
    answer = [lux, luy, rdx+1, rdy+1]
    return answer