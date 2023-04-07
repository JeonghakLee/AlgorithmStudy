import sys
input = sys.stdin.readline
t = int(input())
for i in range(t):
  answer = "YES"
  n = int(input())
  arr = []
  st = set()
  for j in range(n):
    s = input().rstrip()
    arr.append(s)
    st.add(s)
  for j in range(len(arr)):
    for k in range(1, len(arr[j])):
      if arr[j][:k] in st:
        answer = "NO"
        break
  print(answer)