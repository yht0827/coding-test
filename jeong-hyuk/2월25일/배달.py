import heapq

def dijkstra(graph, start, K):
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    queue = []
    heapq.heappush(queue, [distances[start], start])

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        if distances[current_node] < current_distance:
            continue

        for adjacent, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance <= K and distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])

    count = 0
    for distance in distances.values():
        if distance <= K:
            count += 1

    return count

def solution(N, road, K):
    graph = {node: {} for node in range(1, N + 1)}

    for u, v, w in road:
        if v in graph[u]:
            graph[u][v] = min(graph[u][v], w)
            graph[v][u] = min(graph[v][u], w)
        else:
            graph[u][v] = w
            graph[v][u] = w

    return dijkstra(graph, 1, K)
