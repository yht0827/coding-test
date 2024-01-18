def solution(expression):
    result = []
    number_of_cases = [["+", "-", "*"], ["-", "+", "*"], ["+", "*", "-"], ["-", "*", "+"], ["*", "+", "-"], ["*", "-", "+"]]
    n = ''
    expression_list = []
    for i in expression:
        if i != "+" and i != "-" and i != "*":
            n += i
        else:
            expression_list.append(n)
            expression_list.append(i)
            n = ''
    expression_list.append(n)

    for case in number_of_cases:
        expression_list_copy = expression_list.copy()
        for sign in case:
            while sign in expression_list_copy:
                sign_index = expression_list_copy.index(sign)
                sign_num = eval(expression_list_copy[sign_index-1] + sign + expression_list_copy[sign_index+1])

                del expression_list_copy[sign_index-1]
                del expression_list_copy[sign_index-1]
                del expression_list_copy[sign_index-1]

                expression_list_copy.insert(sign_index-1, str(sign_num))
        result.append(abs(int(expression_list_copy[0])))
            
    answer = max(result)

    return answer

print(solution("100-200*300-500+20"))