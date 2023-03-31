N, T = map(int,input().split()) # 시험 단원의 개수, 공부할 수 있는 총 시간
dp = [[0 for _ in range(T+1)] for _ in range(N+1)]

subject = [[0, 0]]
for i in range(N):
  time, score = map(int,input().split()) # 시간, 배점
  subject.append([time, score])

for i in range(1, N+1):
  for j in range(1, T+1):
    if j >= subject[i][0]: # 공부할 수 있는 시간을 초과하지 않을 경우
      dp[i][j] = max(dp[i-1][j], dp[i-1][j-subject[i][0]] + subject[i][1])
    else:
      dp[i][j] = dp[i-1][j]
print(dp[N][T])
  