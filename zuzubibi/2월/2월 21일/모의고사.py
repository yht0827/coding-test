def solution(answers):
    a = [1,2,3,4,5]
    b = [2,1,2,3,2,4,2,5]
    c = [3,3,1,1,2,2,4,4,5,5]
    arr = [0,0,0]
    if len(a) < len(answers):
        a *= len(answers) //len(a)+1
    if len(b) < len(answers):
        b *= len(answers) //len(b)+1
    if len(c) < len(answers):
        c *= len(answers) //len(c)+1

    for i in range(len(answers)):
        if answers[i] == a[i]:
            arr[0] +=1
        if answers[i] == b[i]:
            arr[1] +=1
        if answers[i] == c[i]:
            arr[2] += 1

    return [i+1  for i, d in enumerate(arr) if d == max(arr)]

def anotherSolution(answers):
    pat1 = [1,2,3,4,5]
    pat2 = [2,1,2,3,2,4,2,5]
    pat3 = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0]

    for i, answer in enumerate(answers):
        if answer == pat1[i%len(pat1)]:
            score[0] += 1
        if answer == pat2[i%len(pat2)]:
            score[1] += 1
        if answer == pat3[i%len(pat3)]:
            score[2] += 1

    return [i+1 for i,d in enumerate(score) if d == max(score)]

print(anotherSolution([1,2,3,4,5])) # [1]
print(anotherSolution([1,3,2,4,2])) # [1,2,3]
print(anotherSolution([1, 1, 1, 1, 1, 1])) # [1,3]