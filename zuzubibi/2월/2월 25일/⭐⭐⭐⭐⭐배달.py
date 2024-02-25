# 다익스트라 알고리즘
# https://jennnn.tistory.com/83

import heapq
def dijkstra(dist, adj):
    # 출발 노드를 기준으로 각 노드들의 최소비용 탐색
    heap = []
    heapq.heappush(heap, [0,1]) # 거리, 노드
    while heap:
        cost, node = heapq.heappop(heap)
        for c, n in adj[node]:
            if cost+c < dist[n]:
                dist[n] = cost + c
                heapq.heappush(heap, [cost+c, n])

def solution(N, road, K):
    dist = [float('inf')]*(N+1) # dist배열 만들고 최소거리 갱신
    dist[1] = 0
    adj = [[] for _ in range(N+1)] # 인접노드 & 거리 기록할 배열
    for r in road:
        adj[r[0]].append([r[2], r[1]])
        adj[r[1]].append([r[2],r[0]])
    dijkstra(dist, adj) 
    return len([i for i in dist if i <= K])


print(solution(5, [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]], 3)) #4
print(solution(6,[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4)) #4