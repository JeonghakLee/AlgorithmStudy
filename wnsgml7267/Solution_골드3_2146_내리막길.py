import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

#세로, 가로
M, N = map(int,input().split())
graph = []
for i in range(M):
  graph.append(list(map(int,input().split())))

dp = [[-1]*N for _ in range(M)]
dx = [1,-1,0,0]
dy = [0,0,1,-1]

def DFS(x,y):
  #도착 지점에 도달하면 1(한가지 경우의 수)리턴
  if (x == (M-1)) and  (y == (N-1)):
    return 1

  #방문한 적이 있으면 그 위치에서 출발하는 경우의 수 리턴
  if dp[x][y] != -1:
    return dp[x][y]  
  
  count = 0
  
  for i in range(4):
    nx = x + dx[i]
    ny = y +dy[i]
    if 0 <= nx < M and 0 <= ny < N and graph[x][y] > graph[nx][ny]:
      count += DFS(nx, ny)
  dp[x][y] = count
  return dp[x][y]

print(DFS(0,0))