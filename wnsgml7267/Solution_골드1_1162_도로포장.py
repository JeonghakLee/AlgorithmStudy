from heapq import heappop, heappush
import sys
input = sys.stdin.readline
INF = sys.maxsize
n, m, k = map(int,input().split()) # 도시, 도로, 포장
graph = [[] for _ in range(n+1)]
distance = [[INF for _ in range(k+1)] for _ in range(n+1)] # distance[n][k]
for i in range(m):
    x, y, time = map(int,input().split())
    graph[x].append((time, y))
    graph[y].append((time, x))

def dijk(s):
    heap = []
    cnt = 0
    distance[s][cnt] = 0
    heappush(heap, (0, s, cnt))

    while heap:
        t, now, cnt = heappop(heap)
        if distance[now][cnt] < t:
            continue
        for time, next in graph[now]:
            next_time = time + t
            if distance[next][cnt] > next_time:
                distance[next][cnt] = next_time
                heappush(heap, (next_time, next, cnt)) # 동일한 cnt개의 포장 상태에서 다음 도시
            if cnt < k and distance[next][cnt+1] > t: # 포장 개수 증가시킨 최소거리
                distance[next][cnt+1] = t
                heappush(heap, (t, next, cnt+1))
            
dijk(1)
print(min(distance[n])) # 마지막 도로의 최소거리