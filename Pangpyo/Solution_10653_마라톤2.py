# 10653 마라톤 2 G3

import sys


def solution():
    input = sys.stdin.readline
    N, K = map(int, input().split())

    point = [tuple(map(int, input().split())) for _ in range(N)]

    def dist(a, b):
        x, y = point[a]
        nx, ny = point[b]
        return abs(x - nx) + abs(y - ny)

    D = [[float("inf")] * (K + 1) for _ in range(N)]

    D[0][0] = 0

    for i in range(1, N):
        for j in range(K + 1):
            if j > i:
                break
            for k in range(j + 1):
                d = D[i - k - 1][j - k] + dist(i - k - 1, i)
                D[i][j] = min(d, D[i][j])

    return D[-1][-1]


if __name__ == "__main__":
    print(solution())