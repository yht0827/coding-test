from math import gcd
def solution(w,h):
    answer = 1

    w, h = max(w,h), min(w, h) # 편의상 가로가 더 길게

    g = gcd(w,h) # 최대 공약수 -> (패턴 반복수)

    ww = w // g
    hh = h // g # 간소화 된 w, h
    # print(ww, hh, g)

    # ww * hh 에서 대각선을 지나지 않는 크기는 (ww-1) * (hh-1)
    # cut: 패턴의 한부분 ww * hh 에서 잘리지 않는 부분을 뺀 것
    # 실제로는 w + h -1 과 같다.
    cut = ( (ww * hh) - (ww - 1) * (hh - 1) )


    answer = w * h - cut * g

    return answer