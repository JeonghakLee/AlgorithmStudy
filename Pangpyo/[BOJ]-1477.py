from heapq import heappop, heappush
import sys

input = sys.stdin.readline

N, M, L = map(int, input().split())

nums = sorted([0] + list(map(int, input().split())) + [L])

heap = []

for i in range(1, N+2) :
    heappush(heap, (-(nums[i]-nums[i-1]), (nums[i]-nums[i-1]),0))


while M:
    l, ol, cnt = heappop(heap)
    cnt += 1
    M -= 1
    nl = -ol//(cnt+1)
    heappush(heap, (nl, ol, cnt))


print(-heap[0][0])