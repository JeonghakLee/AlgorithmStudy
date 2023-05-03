import sys
from heapq import heappop, heappush
def solution() :
  input = sys.stdin.readline
  N, M, K = map(int, input().split())
  graph = [[] for _ in range(N+1)]
  for i in range(M) :
    u, v, d = map(int, input().split())
    graph[u].append((v, d))
    graph[v].append((u, d))
  ans = 0
  pq = [(0, K, 1)]
  inf = sys.maxsize
  D = [[inf]*(K+1) for _ in range(N+1)]
  D[1][K] = 0
  while pq :
    d, k, n = heappop(pq)
    if d > D[n][k] :
      continue
    for nn, nd in graph[n] :
      ndd = nd+d
      if ndd < D[nn][k] :
        D[nn][k] = ndd
        heappush(pq, (ndd, k, nn))
      if k > 0 and d < D[nn][k-1]:
        D[nn][k-1] = d
        heappush(pq, (d, k-1, nn))
  ans = min(D[-1])

  return ans

if __name__ == "__main__" :
  print(solution())