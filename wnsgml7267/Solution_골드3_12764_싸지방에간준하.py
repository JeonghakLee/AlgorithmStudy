import sys
import heapq
input = sys.stdin.readline

n = int(input())
heap = []
cp = [0 for _ in range(n)]
cnt = [0 for _ in range(n)]

cp_cnt = 0

for _ in range(n):
    p = list(map(int,input().split()))
    heapq.heappush(heap, p)

while heap:
    x = heapq.heappop(heap)
    for i in range(len(cp)):
        if cp[i] <= x[0]:
            if cp[i] == 0:
                cp_cnt += 1
            cp[i] = x[1]
            cnt[i] += 1
            break
print(cp_cnt)
print(' '.join(list(map(str, cnt[0:cp_cnt]))))