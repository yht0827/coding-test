def solution(numbers):
    arr = []
    for n in numbers:
        # 짝수일 경우
        if n % 2 == 0:
            arr.append(n+1)
            continue

        # 홀수일 경우
        number_bin = '0' + bin(n)[2:]
        number_bin = number_bin[:number_bin.rindex('0')]+'10'+ number_bin[number_bin.rindex('0')+2:]
        arr.append(int(number_bin,2)) # 10진수 --> 2진수
    return arr


print(solution([2,7,9])) #[3,11]