def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        if phone_book[i+1].find(phone_book[i]) == 0:
            answer = False
    return answer