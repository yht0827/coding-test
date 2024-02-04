from collections import deque
import copy

def solution(storey):
    answer = 0
    #있는 층에서, 0층까지 가는 최소한의 경우의 수는?
    #현재 층 + 버튼의 결과의 층으로 가되, 결과가 0 미만이면 움직이지 않는다

    # 최대 c 정의
    str_storey = str(storey)
    digit = [int(v) for i, v in enumerate(str_storey)]
    len_digit = len(digit)
    result = []


    def digit_exc(pre_digit, pre_dimension, pre_case):
        digit = copy.deepcopy(pre_digit)
        digit2 = copy.deepcopy(pre_digit)
        case = copy.deepcopy(pre_case)
        case2 = copy.deepcopy(pre_case)
        dimension = copy.deepcopy(pre_dimension)

        if len(digit) - 1 >= dimension:
            print('#########', dimension, digit)
            # 뺀 경우
            case += digit[-1 * dimension]
            digit[-1 * dimension] = 0
            #나머지 계산
            param_case = case # 계산전, 넘길 케이스값 저장
            for i in digit[:-1 * dimension]:
                case+= i

            # 더한 경우
            case2 += 10 - digit2[-1 * dimension]
            digit2[-1 * (dimension)]  = 0
            digit2[-1 * (dimension+1)] +=1 

            while 10 in digit2:
                tar_index = digit2.index(10)
                digit2[tar_index] = 0
                if tar_index - 1 < 0:
                    digit2.insert(0, 1)
                else:
                    digit2[tar_index - 1] += 1

            #나머지 계산
            param_case2 = case2 # 계산전, 넘길 케이스값 저장
            for i in digit2[:-1 * dimension]:
                case2+= i

            digit_exc(digit, dimension+1, param_case)
            digit_exc(digit2, dimension+1, param_case2)

            result.append(min(case, case2))
        elif len(digit) == dimension:
            # 더한 경우
            case2 += 10 - digit2[-1 * dimension]
            digit2[-1 * (dimension)]  = 0
            case2 += 1 # 마지막 1되는 경우
            result.append(case2)


    digit_exc(digit, 1, 0)




    return min(result)