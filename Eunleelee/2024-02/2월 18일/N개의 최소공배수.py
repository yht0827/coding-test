def solution(arr):
    answer = 0

    arr.sort()

    value = 0
    i = 1
    while 1:
      gog = i * arr[-1]
      for j in range(len(arr)-1):
        if gog % arr[j] != 0:
          value = 0
          break
        else:
          value = 1
      if value == 1:
        break
      i += 1

    answer = gog
    return answer
