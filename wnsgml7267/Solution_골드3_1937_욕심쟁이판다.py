import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int,input().split())))
dx, dy = (1,-1,0,0), (0,0,1,-1)
dp = [[0] * n for _ in range(n)]
answer = 0

def dfs(x, y):
    if dp[x][y]: return dp[x][y] # 방문한 경로
    dp[x][y] = 1
    for i in range(4):
        nx, ny = dx[i] + x, dy[i] + y
        if 0 <= nx < n and 0 <= ny < n and graph[x][y] < graph[nx][ny]:
            dp[x][y] = max(dp[x][y], dfs(nx, ny) + 1)
    return dp[x][y]

for i in range(n):
    for j in range(n):
        answer = max(answer, dfs(i, j))
print(answer)