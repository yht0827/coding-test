from heapq import heappush, heappop

def make_matrix(rows, columns):
    matrix = [[0 for x in range(columns)] for y in range(rows)]

    for y in range(rows):
        for x in range(columns):
            matrix[y][x] = y*columns + x + 1

    return matrix


def solution(rows, columns, queries):
    answer = []

    matrix = make_matrix(rows, columns)

    for que in queries:
        y1, x1, y2, x2 = que
        heap = []

        y1x1 = matrix[y1-1][x1-1]
        y1x2 = matrix[y1-1][x2-1]
        y2x1 = matrix[y2-1][x1-1]
        y2x2 = matrix[y2-1][x2-1]

        heappush(heap,y1x1)
        heappush(heap,y1x2)
        heappush(heap,y2x1)
        heappush(heap,y2x2)

        for x in range(x2 - 1, x1 - 1, -1):
            matrix[y1-1][x] = matrix[y1-1][x-1]
            heappush(heap, matrix[y1-1][x])

        for y in range(y2 - 1, y1 - 1, -1):
            matrix[y][x2-1] = matrix[y-1][x2-1]
            heappush(heap, matrix[y][x2-1])

        for x in range(x1 - 1, x2 - 1, 1):
            matrix[y2-1][x] = matrix[y2-1][x+1]
            heappush(heap, matrix[y2-1][x])

        for y in range(y1 - 1, y2 - 1, 1):
            matrix[y][x1-1] = matrix[y+1][x1-1]
            heappush(heap, matrix[y][x1-1])

        matrix[y1][x2-1] = y1x2
        matrix[y2-1][x2-2] = y2x2
        matrix[y2-2][x1-1] = y2x1

        answer.append(heap[0])

    return answer