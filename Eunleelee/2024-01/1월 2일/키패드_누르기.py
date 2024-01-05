def solution(numbers, hand):
  L_location = {'1' : 1, '4' : 2, '7' : 3, '*' : 4}  # 왼쪽에 있는 키판 위치를 딕셔너리로 저장
  R_location = {'3' : 1, '6' : 2, '9' : 3, '#' : 4}  # 오른쪽에 있는 키판 위치를 딕셔너리로 저장
  
  # 모든 키판의 위치를 표시
  All_location = {'1' : 1, '4' : 2, '7' : 3, '*' : 4, '3' : 1, '6' : 2, '9' : 3, '#' : 4, '2' : 1, '5' : 2, '8' : 3, '0' : 4}
  middle = ['2', '5', '8', '0']  # 가운데 자판만 배열로 저장
  left_now = '*'  # 현재 왼쪽 위치를 저장
  right_now = '#'  # 현재 오른쪽 위치를 저장
  answer = ''

  for num in numbers:
    num = str(num)
    if num in L_location:  # 눌러야 하는 자판이 왼쪽에 있으면 
      answer += 'L'
      left_now = num  
    elif num in R_location:  # 눌러야 하는 자판이 오른쪽에 있으면 
      answer += 'R'
      right_now = num
    else:  # 눌러야 하는 자판이 가운데에 있으면
      left_distance = abs(All_location[left_now] - All_location[num])   # 눌러야 하는 자판과 왼쪽 현재 위치와의 거리
      right_distance = abs(All_location[right_now] - All_location[num])  # 눌러야 하는 자판과 오른쪽 현재 위치와의 거리
      
      if left_now in middle:  # 왼쪽 현재 위치가 가운데 자판에 있다면 거리에서 -1
        left_distance -= 1
      if right_now in middle:  # 오른쪽 현재 위치가 가운데 자판에 있다면 거리에서 -1
        right_distance -= 1

      if left_distance < right_distance:  # 왼쪽이 눌러야 하는 자판과 가깝다면
        answer += 'L'
        left_now = num
      elif right_distance < left_distance: # 오른쪽이 눌러야 하는 자판과 가깝다면
        answer += 'R'
        right_now = num
      elif right_distance == left_distance: # 왼쪽과 오른쪽의 거리가 같다면
        if hand == 'right':
          answer += 'R'
          right_now = num
        elif hand == 'left':
          answer += 'L'
          left_now = num
    
  return answer
  
print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))


