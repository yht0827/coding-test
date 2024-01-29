# 확인해야 하는 두 가지 조건
# 1. 순서대로 진행이 되는지
# 2. 먼저 배워야 하는 스킬을 배우는 지

def solution(skill, skill_trees):
    answer = 0
    skill_list = list(skill)
    
    for skill_tree in skill_trees:
        index_list = []
        for i in skill_list:
            skill_index = skill_tree.find(i)
            if skill_index == -1:
                index_list.append(100)
            else:
                index_list.append(skill_index)
        
        if index_list == sorted(index_list):
            answer += 1
            
    return answer

print(solution("CBD",	["BACDE", "CBADF", "AECB", "BDA"]))