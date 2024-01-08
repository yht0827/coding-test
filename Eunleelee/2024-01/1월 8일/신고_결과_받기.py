# 여러 번 신고해도 같은 사람이면 신고 횟수는 1회로 처리
# k번 이상 신고된 유저는 정지, 신고한 모든 유저에게 메일 보냄
# 필요한 변수 - 몇 번 신고 당했는지, 누가 신고를 했는지

def solution(id_list, report, k):
  reported_num = dict()   # 각 유저마다 신고당한 횟수를 저장
  reported_user = dict()  # 각 유저를 신고한 유저들을 저장
  stop_mail_user = []
  result = [0] * len(id_list)

  report = list(set(report))  # 중복으로 신고한 것은 제거

  for i in report:
    user, reported_id = i.split(' ')

    if reported_id not in reported_user:  # 신고당한 id가 기록에 없다면
      reported_user[reported_id] = [user]
      reported_num[reported_id] = 1
    else: 
      reported_user[reported_id].append(user)
      reported_num[reported_id] += 1
    
    # 신고당한 횟수가 k 번을 넘고 stop_mail_user에 id가 없다면
    if reported_num[reported_id] >= k and reported_id not in stop_mail_user:
      stop_mail_user.append(reported_id)
    
  for stop_user in stop_mail_user:
    for mail_user in reported_user[stop_user]:
      result[id_list.index(mail_user)] += 1

  return result
print(solution(["ab", "b"],	["ab b"], 1))


