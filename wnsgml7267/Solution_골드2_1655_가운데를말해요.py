import sys
from heapq import heappop, heappush
input = sys.stdin.readline

left, right = [], []

for i in range(int(input())):
    num = int(input())

    if len(left) == len(right):
        heappush(left, -num)
    else:
        heappush(right, num)
    
    if right and -left[0] > right[0]:
        heappush(right, -heappop(left))
        heappush(left, -heappop(right))
    print(-left[0])
