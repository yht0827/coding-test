def solution(word):
    answer = 0
    vowel = ['A', 'E', 'I', 'O', 'U']

    for a in range(5):
        now = vowel[a]
        answer += 1
        if word == now:
          return answer
        for b in range(5):
            now = vowel[a] + vowel[b]
            answer += 1
            if word == now:
              return answer
            for c in range(5):
                now = vowel[a] + vowel[b] + vowel[c]
                answer += 1
                if word == now:
                    return answer
                for d in range(5):
                    now = vowel[a] + vowel[b] + vowel[c] + vowel[d]
                    answer += 1
                    if word == now:
                        return answer
                    for e in range(5):
                        now = vowel[a] + vowel[b] + vowel[c] + vowel[d] + vowel[e]
                        answer += 1
                        if word == now:
                            return answer

    return answer

print(solution("EIO"))