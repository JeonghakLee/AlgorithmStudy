import sys
input = sys.stdin.readline
n = int(input())
v = [-1 for _ in range(2000001)]
stack = [-1]

for i in range(n):
    a, b = map(int,input().split())
    v[a-b], v[a+b] = i, i

for i in range(1000001, 2000001): # 음수부터 시작
    if v[i] != -1:
        if stack[-1] == v[i]: stack.pop()
        else: stack.append(v[i])

for i in range(1000001): # 0부터 시작
    if v[i] != -1:
        if stack[-1] == v[i]: stack.pop()            
        else: stack.append(v[i])
            
if len(stack)==1: print("YES")
else: print("NO")
