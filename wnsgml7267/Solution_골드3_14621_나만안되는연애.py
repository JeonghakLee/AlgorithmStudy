from heapq import heappop, heappush

def find(x):
    if x != parents[x]:
        parents[x] = find(parents[x])
    return parents[x]

def union(x, y):
    aRoot = find(x)
    bRoot = find(y)
    parents[bRoot] = aRoot
    
n, m = map(int,input().split())
uni = [0] + list(input().split())
heap = [] # 가중치 + 좌표
total = 0 # 최소 가중치 합
parents = [i for i in range(n+1)] # 루트 노드
visited = [False for _ in range(n+1)] # 방문 체크

for i in range(m):
    u, v, cost = map(int,input().split())
    heappush(heap, (cost, u, v))

while(heap):
    cost, x, y = heappop(heap)
    if find(x) != find(y) and uni[x] != uni[y]:
        visited[x], visited[y] = True, True
        union(x, y)
        total += cost

if visited.count(False) == 1: # 모두 방문
    print(total)
else:
    print(-1)
        


