import sys

input = sys.stdin.readline

N, T = map(int, input().split())

subj = [tuple(map(int, input().split())) for _ in range(N)]

D = [[0] * (T + 1) for _ in range(N + 1)]

for t in range(1, T + 1):
    for i in range(1, N + 1):
        if t - subj[i - 1][0] >= 0:
            D[i][t] = max(D[i - 1][t], D[i - 1][t - subj[i - 1][0]] + subj[i - 1][1])
        else:
            D[i][t] = max(D[i - 1][t], D[i][t - 1])

print(D[-1][-1])