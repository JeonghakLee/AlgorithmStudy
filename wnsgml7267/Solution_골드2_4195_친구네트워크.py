import sys
input = sys.stdin.readline

def find(a): # (경로 압축) 부모 노드 구하기
  if a != parents[a]:
    parents[a] = find(parents[a])
  return parents[a]

def union(a, b):
  aRoot = find(a)
  bRoot = find(b)
  if aRoot != bRoot:
    parents[bRoot] = aRoot
    cnt[aRoot] += cnt[bRoot] # aRoot에 친구 수 합치기

for _ in range(int(input())):
  parents = {} # 부모 노드 구하기
  cnt = {} # 부모와 친구 수 구하기
  for i in range(int(input())):
    a, b = input().rstrip().split()
    if a not in parents:
      parents[a] = a
      cnt[a] = 1
    if b not in parents:
      parents[b] = b
      cnt[b] = 1

    union(a, b)

    print(cnt[find(a)]) # a의 부모 노드의 친구 수 출력
      

  