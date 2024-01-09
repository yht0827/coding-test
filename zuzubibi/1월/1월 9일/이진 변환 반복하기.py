def solution(s):
    turns = 0
    zeros = 0
    while True:
        if s == "1":
            turns += 1
            break

        if "0" in s:
            zeros += s.count("0")
            s = s.replace("0", "")
        else:
            turns += 1
            s = len(s)
            s = str(bin(s)[2:])

    return[turns, zeros]

# --------------------------------------
def othersSolution(s):
    a,b = 0,0
    while s!= '1':
        a += 1
        num = s.count('1')
        b += len(s) - num
        s = bin(num)[2:]
    return [a,b]

print(othersSolution("110010101001")) #[3,8]
print(othersSolution("01110")) #[3,3]
print(othersSolution("1111111")) # [4,1]