import math

def solution(m, musicinfos):
    m = m.replace('A#', 'H').replace('C#', 'I').replace('D#', 'J').replace('F#', 'K').replace('G#', 'L')
    music_info = []
    
    for num, musicinfo in enumerate(musicinfos):
        start, end, name, music = musicinfo.split(',')   
        
        music = music.replace('A#', 'H').replace('C#', 'I').replace('D#', 'J').replace('F#', 'K').replace('G#', 'L')
        music_len = (int(end[:2]) * 60 + int(end[3:])) - (int(start[:2]) * 60 + int(start[3:]))
        
        if len(music) < music_len:
            music += music * (music_len // len(music)) + music[:(music_len % len(music))]
        elif len(music) > music_len:
            music = music[:music_len]
        
        if m in music:
            music_info.append([music_len, name, num])
            
    if len(music_info) == 0:
        return "(None)"
    
    if len(music_info) != 1:
        music_info = sorted(music_info, key = lambda x : (-x[0], x[2]))
  
    return music_info[0][1]