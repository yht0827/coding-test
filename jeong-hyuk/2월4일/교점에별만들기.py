def solution(line):
    dot_list = []
    
    # 직선들의 교점 찾기
    for i in range(len(line)):
        A, B, E = line[i]
        for j in range(i + 1, len(line)):
            C, D, F = line[j]
            
            bunja = A * D - B * C
            if int(bunja) == 0:
                continue

            x = (B * F - E * D) / bunja
            y = (E * C - A * F) / bunja

            # 정수인지 소수인지 확인
            if x.is_integer() and y.is_integer():
                x, y = int(x), int(y)
                dot_list.append([x, y])

    # 배열 크기 정하기
    x_dot_list = [dot[0] for dot in dot_list]
    y_dot_list = [dot[1] for dot in dot_list]
    x_min, x_max = min(x_dot_list), max(x_dot_list)
    y_min, y_max = min(y_dot_list), max(y_dot_list)

    # 배열 만들기
    arr = [['.' for _ in range(x_max - x_min + 1)] for _ in range(y_max - y_min + 1)]

    # 별 찍기
    for dot in dot_list:
        x, y = dot
        arr[y_max - y][x - x_min] = '*'

    return [''.join(a) for a in arr]
