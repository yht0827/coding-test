def solution(numbers):
    answer = []

    def toBinary(number):
        ans = ''
        while number > 0:
            ans += str(number%2)
            number = number//2

        add_zero = 4-(len(ans)%4)
        ans += '0' * add_zero

        return ans[::-1]

    def toDecimal(number):
        ans = 0; l = len(number)-1
        for n in number:
            ans += (2**l)*int(n)
            l -= 1

        return ans

    for num in numbers:
        if num%2 == 0:
            answer.append(num+1)
        else:
            odd_to_binary = toBinary(num)

            for i in range(len(odd_to_binary)-1, -1, -1):
                if odd_to_binary[i] == '0':
                    odd_to_binary = odd_to_binary[:i] + '10' + odd_to_binary[i+2:]
                    answer.append(toDecimal(odd_to_binary))
                    break

    return answer
