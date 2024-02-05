# https://concho.tistory.com/179

# 파이썬은 숫자 커도 상관 없어서 너무 좋음!
def solution(line):
    answer, starSet = [], set()
    # 중복을 제외하고 순서 없이 뽑기
    for i in range(len(line)):
        for j in range(i+1,len(line)):
            A,B,E = line[i]
            C,D,F = line[j]
            # 주어진 식으로 교점 구하기
            upX, down, upY = (B*F - E*D), (A*D - B*C), (E*C - A*F)
            if A*D != B*C and upX % down == 0 and upY % down == 0:
                y, x = upY//down, upX//down
                starSet.add((y, x))
                
    # 좌표 영역 구하기
    yMax, yMin = max(starSet, key= lambda x:x[0])[0], min(starSet, key= lambda x:x[0])[0]
    xMax, xMin = max(starSet, key= lambda x:x[1])[1], min(starSet, key= lambda x:x[1])[1]
    
    # 별 찍기, 한라인씩 찍기
    for i in range(yMax - yMin, -1 , -1):
        oneLine = []
        for j in range(xMax - xMin + 1):
            oneLine.append('*' if (i+ yMin, j+ xMin) in starSet else '.')
        answer.append(''.join(oneLine))
    return answer


#["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]
print(solution([[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]))

# ["*.*"] 
print(solution([[0, 1, -1], [1, 0, -1], [1, 0, 1]]))

# ["*"]
print(solution([[1, -1, 0], [2, -1, 0]]))

# ["*"]
print(solution([[1, -1, 0], [2, -1, 0], [4, -1, 0]]))