def solution(participant, completion):
    
    arr = [ i for i in participant if participant.count(i) == 2]
    if len(arr) ==0:
        return list(set(participant)- set(completion))[0]
    else:
        return list(set(arr))[0]

# ----------------------------------------------------------------
def anotherSolution1(participant, completion):

    participant.sort()
    completion.sort()

    for i,j in zip(participant, completion):
        if i!=j:
            return i
    return participant[-1]

def anotherSolution2(participant, completion):
    hash_dict = {}
    sumHash = 0
    for i in participant:
        hash_dict[hash(i)]=i
        sumHash += hash(i)
    
    for j in completion:
        sumHash -= hash(j)
    
    return hash_dict[sumHash]

from collections import Counter
def anotherSolution3(participant, completion):
    dict_result = Counter(participant) - Counter(completion)
    return list(dict_result.keys())[0]


print(anotherSolution1(["leo", "kiki", "eden"], ["eden", "kiki"])) #"leo"
print(anotherSolution2(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"])) # 	"vinko"
print(anotherSolution3(["mislav", "stanko", "mislav", "ana"], 	["stanko", "ana", "mislav"])) #"mislav"