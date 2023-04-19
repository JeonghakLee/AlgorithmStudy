from collections import deque
n = int(input())
level = [0 for _ in range(n+1)] # 차수
time = [0 for _ in range(n+1)] # 시간
graph = [[] for _ in range(n+1)] # 관계
total_time = [0 for _ in range(n+1)] # 최소 시간 합
q = deque()

for i in range(1,n+1):
    arr = list(map(int,input().split()))[:-1]
    time[i] = arr[0] # 건물 당 시간 저장
    for j in arr[1:]:
        graph[j].append(i) # j가 i의 선수 건물 번호
        level[i] += 1 # 선수 건물부터 지어야하므로 현재 건물 진입차수 증가
for i in range(1, n+1):
    if level[i] == 0: # 진입 차수가 0이면 큐에 삽입
        q.append(i)

while q:
    x = q.popleft()

    total_time[x] += time[x] # 선수 건물을 지은 시간에 현재 시간을 추가
    for j in graph[x]:
        level[j] -= 1  # 진입 차수 감소
        total_time[j] = max(total_time[j], total_time[x])
        if level[j] == 0:
            q.append(j)
for i in range(1, n+1):
    print(total_time[i])
