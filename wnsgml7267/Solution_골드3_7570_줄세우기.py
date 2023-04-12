from collections import defaultdict as dd
n = int(input())
arr = list(map(int,input().split()))
dic = dd(int)
for i in range(n):
  t = arr[i] 
  dic[t] = 1
  if dic[t-1]: # 연속된 번호라면
    dic[t] = dic[t-1] + 1
print(n - max(dic.values()))