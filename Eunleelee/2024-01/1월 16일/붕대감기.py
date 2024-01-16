from collections import deque

def solution(bandage, health, attacks):
    attacks = deque(attacks)
    sequence_success = 0
    max_health = health

    for i in range(1, attacks[-1][0] + 1):
      if i == attacks[0][0]:
         health -= attacks[0][1]
         attacks.popleft()
         sequence_success = 0
      
         if health <= 0:
            return -1

      elif health < max_health:
         sequence_success += 1
         health += bandage[1]

         if sequence_success == bandage[0]:
            health += bandage[2]
            sequence_success = 0 
      
      if health > max_health:
         health = max_health
        
    return health


print(solution([5, 1, 5], 30,	[[2, 10], [9, 15], [10, 5], [11, 5]]))