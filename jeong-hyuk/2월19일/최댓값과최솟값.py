def solution(s):
    numbers = list(map(int, s.split()))
    max_num = str(max(numbers))
    min_num = str(min(numbers))
    return min_num + " " + max_num