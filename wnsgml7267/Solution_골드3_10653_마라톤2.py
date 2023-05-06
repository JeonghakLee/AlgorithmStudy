# 맨해튼 거리 절댓값 체크 할 것
n, k = map(int,input().split())
checkpoint = []
for i in range(n):
    x, y = map(int,input().split())
    checkpoint.append((x,y))
dist = [[0 for _ in range(n)] for _ in range(n)] # i ~ j 체크포인트 사이의 거리
for i in range(n):
    for j in range(n):
        dist[i][j] = abs(checkpoint[i][0] - checkpoint[j][0]) + abs(checkpoint[i][1] - checkpoint[j][1])

dp = [[10**9 for _ in range(n)] for _ in range(k+1)] # dp[k][n]
dp[0][0] = 0

# 체크 포인트를 건너뛰지 않았을 경우
for i in range(1, n): # 시작, 끝 체크포인트 제외
    dp[0][i] = dp[0][i-1] + dist[i-1][i]

# 체크 포인트 1~k번 건너뛰는 경우
for i in range(1, k+1):
    dp[i][0], dp[i][1] = 0, dp[i-1][1]
    dp[i][i] = dist[0][i]
    for j in range(1, n):
        for m in range(i, 0, -1):
            if j - m - 1 < 0:
                continue
            dp[i][j] = min(dp[i][j], dp[i-m][j-m-1] + dist[j][j-m-1], dp[i][j - 1] + dist[j - 1][j])
print(dp[-1][-1])