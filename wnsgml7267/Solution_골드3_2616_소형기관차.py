n = int(input()) # 객차 수
arr = [0] + list(map(int,input().split())) # 번호당 손님 수
m = int(input()) # 최대로 끌 수 있는 객차의 수
dp = [[0 for _ in range(n+1)] for _ in range(3)] # [소형기관차 3대][객차]
sum_arr = [0 for _ in range(n+1)] # 누적합
for i in range(1,n+1):
  sum_arr[i] = sum_arr[i-1] + arr[i]

for i in range(3): # 소형 기관차 3대
  for j in range((i+1)*m, n+1): # 소형 기관차끼리 안겹치게 범위 설정
    if i == 0: # 이전 기관차가 없을 경우
      dp[i][j] = max(dp[i][j-1], sum_arr[j] - sum_arr[j-m]) # 이전 객차까지의 최댓값, 현재 객차 포함한 최댓값
    else:
      dp[i][j] = max(dp[i][j-1], dp[i-1][j-m] + sum_arr[j] - sum_arr[j-m]) #이전 객차까지의 최댓값, 이전 기관차까지 최댓값 + 현재 객차 포함한 최댓값
print(dp[-1][-1])