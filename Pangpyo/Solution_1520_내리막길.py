import sys


input = sys.stdin.readline

sys.setrecursionlimit(10**5)

N, M = map(int, input().split())

L = [list(map(int, input().split())) for _ in range(N)]


dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
D = [[0] * M for _ in range(N)]
D[0][0] = 1

visit = [[0] * M for _ in range(N)]


def dfs(x, y):
    v = D[x][y]
    if v:
        return v
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= N or nx < 0 or ny >= M or ny < 0:
            continue
        if visit[x][y]:
            continue
        if L[nx][ny] > L[x][y]:
            v += dfs(nx, ny)
    D[x][y] = v
    visit[x][y] = 1
    return v


print(dfs(N - 1, M - 1))