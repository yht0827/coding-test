def hanoi(n, start, end, temp):
    if n == 1:
        print(start, "->", end)
    else:
        hanoi(n - 1, start, temp, end)
        print(start, "->", end)
        hanoi(n - 1, temp, end, start)

# 예시
def solution(n):
    print("하노이의 탑 이동 순서:")
    hanoi(n, 1, 3, 2)