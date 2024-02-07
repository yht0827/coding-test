def solution(s):
    result = []

    for i in list(s[1:-1].split(',')):
        arr =[]
        # print(i, end=" ")
        for j in i:
            print(j, end=" ")
            if j =='{':
                continue
            elif j =='}':
                result.append(arr)
                arr = []
            elif j.isdigit():
                arr.append(int(j))
    print(result)
    return 

# -----------------------------------------------------
from collections import Counter
def anotherSolution(s):
    answer = []
    word = s.replace("{","").replace("}", "").split(",")
    count_word = Counter(word).most_common()
    for i in count_word:
        answer.append(int(i[0]))
    return answer

def anotherSolution2(s):
    word_list = list(map(int, s.replace("}", "").replace("{", "").split(",")))
    print(word_list)
    count_dict = Counter(word_list).most_common()
    answer = [item[0] for item in count_dict]
    return answer
print(anotherSolution2("{{2},{2,1},{2,1,3},{2,1,3,4}}")) # [2, 1, 3, 4]
print(anotherSolution2("{{1,2,3},{2,1},{1,2,4,3},{2}}")) # [2, 1, 3, 4]
print(anotherSolution2("{{20,111},{111}}")) # [111, 20]
print(anotherSolution2("{{123}}")) # [123]
print(anotherSolution2("{{4,2,3},{3},{2,3,4,1},{2,3}}")) # [3, 2, 4, 1]