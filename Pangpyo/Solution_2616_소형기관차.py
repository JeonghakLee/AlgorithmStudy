# 2616 소형 기관차 G3 


def solution() :
  N = int(input())

  nums = list(map(int, input().split()))

  K = int(input())
  temp = sum(nums[0:K])
  l = [0, temp]

  D = [[0]*(N-K+2) for _ in range(4)]
  for i in range(K, N) :
      temp = temp + nums[i] - nums[i-K]
      l.append(temp)

  for i in range(1, 4) :
      for j in range(1, N-K+2) :
          temp = 0
          if j - K >= 0 :
              temp = D[i-1][j-K]
          D[i][j] = max(temp+l[j], D[i-1][j], D[i][j-1])
      
  return D[-1][-1]

if __name__ == "__main__" :
    print(solution())