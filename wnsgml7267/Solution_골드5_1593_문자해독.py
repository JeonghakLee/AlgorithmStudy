import sys
input = sys.stdin.readline
W, S = map(int, input().split())
w = input().strip()
s = input().strip()
answer = 0
w_arr = [0] * 58
s_arr = [0] * 58
for i in w:
  w_arr[ord(i) - 65] += 1
start = s[0]
for i in s[:W]:
  s_arr[ord(i)-65] += 1
if w_arr == s_arr:
  answer += 1
for i in range(W, S):
  s_arr[ord(s[i])-65] += 1
  s_arr[ord(s[i-W])-65] -= 1
  if w_arr == s_arr:
    answer += 1
print(answer)