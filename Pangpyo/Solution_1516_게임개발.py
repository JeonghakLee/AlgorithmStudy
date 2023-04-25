# 1516 게임 개발 G3

import sys


def solution():
    input = sys.stdin.readline
    N = int(input())
    costs = [0] * (N + 1)
    parents = [[] for _ in range(N + 1)]
    for i in range(1, N + 1):
        temp = list(map(int, input().split()))
        costs[i] = temp[0]
        for j in range(1, len(temp) - 1):
            parents[i].append(temp[j])
    D = [0] * (N + 1)

    def buildtime(n):
        if D[n]:
            return D[n]
        temp = 0
        for nn in parents[n]:
            temp = max(temp, buildtime(nn))
        D[n] = temp + costs[n]
        return D[n]

    ans = []
    for i in range(1, N + 1):
        ans.append(buildtime(i))
    return ans


if __name__ == "__main__":
    print(*solution(), sep="\n")