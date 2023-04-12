import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

ddr = list(map(int,input().split()))
dp = [[[-1]*5 for _ in range(5)] for _ in range(len(ddr))] # 각 지시사항까지 최소 힘

# 같은 지점 이동 : 힘 1 
# 0 => 이동 : 힘 2
# 반대편 이동 : 힘 4
# 인접 이동 : 힘 3
def move(x, y):
    if x == y:
        return 1
    elif x == 0:
        return 2
    elif abs(y-x) % 2 == 0:
        return 4
    else:
        return 3

def dy(n, l, r):
    global dp
    if n >= len(ddr) - 1: # 끝 지점 도달
        return 0

    if dp[n][l][r] != -1: # 방문한 곳
        return dp[n][l][r]

    dp[n][l][r] = min(dy(n+1, ddr[n], r) + move(l, ddr[n]), dy(n+1, l, ddr[n]) + move(r, ddr[n]))
    return dp[n][l][r]
print(dy(0, 0, 0))