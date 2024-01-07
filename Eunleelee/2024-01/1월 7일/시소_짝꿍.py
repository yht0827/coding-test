from collections import Counter

def solution(weights):
    answer, counter = 0, Counter(weights)

    for i in counter:
        if counter[i] > 0:
            answer += counter[i] * (counter[i] - 1) // 2 # nC2 n!/2!(n - 2)!
            answer += counter[i] * counter[i * 3 / 2]
            answer += counter[i] * counter[i * 2]
            answer += counter[i] * counter[i * 4 / 3]

    return answer