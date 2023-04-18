# 2616 우체국

import sys

def solution() :
  input = sys.stdin.readline

  N = int(input())
  XA = []
  total = 0
  for i in range(N):
      XA.append(tuple(map(int, input().split())))
      total += XA[-1][1]

  XA.sort()

  temp = 0
  for i in range(N):
      temp += XA[i][1]
      if temp >= (total + 1) // 2:
          return XA[i][0]
      

if __name__ == "__main__" :
    print(solution())