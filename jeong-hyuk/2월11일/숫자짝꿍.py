def solution(X, Y):
    # X와 Y의 각 자릿수를 세는 딕셔너리 생성
    x_count = {}
    y_count = {}
    
    # X의 각 자릿수를 세는 과정
    for digit in X:
        if digit in x_count:
            x_count[digit] += 1
        else:
            x_count[digit] = 1
    
    # Y의 각 자릿수를 세는 과정
    for digit in Y:
        if digit in y_count:
            y_count[digit] += 1
        else:
            y_count[digit] = 1
    
    # 공통으로 나타나는 수를 찾아냄
    common_digits = set(x_count.keys()) & set(y_count.keys())
    
    # 짝꿍 수를 만들기 위한 리스트 생성
    pairing_list = []
    
    # 공통으로 나타나는 수를 이용하여 짝꿍 수를 만들기 위한 과정
    for digit in common_digits:
        pairing_list.extend([digit] * min(x_count[digit], y_count[digit]))
    
    # 만약 공통으로 나타나는 수가 없으면 -1 반환
    if len(pairing_list) == 0:
        return "-1"
    
    # 짝꿍 수를 문자열로 변환하여 반환
    result = ''.join(sorted(pairing_list, reverse=True))
    
    # 만약 짝꿍이 0으로만 구성되어 있다면 결과를 0으로 반환
    if all(digit == '0' for digit in result):
        return "0"
    
    return result
