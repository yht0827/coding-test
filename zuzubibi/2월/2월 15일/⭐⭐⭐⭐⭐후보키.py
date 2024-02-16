## 참고 자료: https://velog.io/@sem/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LEVEL2-%ED%9B%84%EB%B3%B4%ED%82%A4-Python
# ---------------------------------------------------------------------
# import pandas as pd
from itertools import combinations
def solution(relation):
    result = 0
    arr = []

    # 1. 역정렬해서 유니크한지 확인 -> 유니크한 놈은 후보키, 그렇지 않은 놈은 조합해서 따져봄
    df = pd.DataFrame(relation)
    df = df.T
    li = df.values.tolist()
    # print(li)
    for i in li:
        if len(i) == len(set(i)):
            result += 1
        else:
            arr.append(i)
    # print(arr)
    # print("====================")
    # 유니크하지 않은 애들 조합해서 유니크한지 따져보기
    # 만약 최소성을 만족시키지 않으면, 세지 말기
    # print(list(combinations(arr,2)))
    # if len(arr)>2:
    #     for i in range(2, len(arr)+1):
            # print(i)
            # print(list(combinations(arr, i)))
            # print("---------------------------")
            # for j in zip(list(combinations(arr,i))):
                # print(j)
    return
def anotherSolution(relation):
    row = len(relation)
    col = len(relation[0])

    # 가능한 속성의 모든 인덱스 조합
    combi = []
    for i in range(1, col+1):
        combi.extend(combinations(range(col), i))

    # 유일성
    unique = []
    for i in combi:
        tmp = [tuple([item[key] for key in i]) for item in relation]

        if len(set(tmp)) == row: # 유일성
            put = True

            for x in unique:
                if set(x).issubset(set(i)): # 최소성
                    put = False
                    break
            if put: unique.append(i)
    return len(unique)


# 비트 연산을 이용한 풀이
def anotherSolution2(relation):
    answer_list = list()
    for i in range(1, 1<<len(relation[0])):
        tmp_set = set()
        for j in range(len(relation)):
            tmp=''
            for k in range(len(relation[0])):
                if i & (1 << k):
                    tmp += str(relation[j][k])
            tmp_set.add(tmp)
        
        if len(tmp_set) == len(relation):
            not_duplicate = True
            for num in answer_list:
                if (num & i) == num:
                    not_duplicate = False
                    break
            if not_duplicate:
                answer_list.append(i)
    return len(answer_list)

# 2
print(anotherSolution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]))