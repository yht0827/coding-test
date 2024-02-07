def solution(storage, num):
    clean_storage = []
    clean_num = []
    for i in range(len(storage)):
        if storage[i] in clean_storage:
            pos = clean_storage.index(storage[i])
            clean_num[pos] += num[i]
            print(pos, clean_num)
        else:
            clean_storage.append(storage[i])
            clean_num.append(num[i])
        print(clean_storage, clean_num)
    # 아래 코드에는 틀린 부분이 없습니다.
            
    max_num = max(clean_num)
    answer = clean_storage[clean_num.index(max_num)]
    return answer

# "pencil"
print(solution(["pencil", "pencil", "pencil", "book"], [2, 4, 3, 1]))
# "leaf"
print(solution(["apple", "steel", "leaf", "apple", "leaf"], [5, 3, 5, 3, 7]))