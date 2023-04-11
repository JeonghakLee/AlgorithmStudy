import sys

def solution() :
    input = sys.stdin.readline

    N, M = map(int, input().split())

    gender = list(input().split())

    lines = sorted([tuple(map(int, input().split())) for _ in range(M)], key=lambda x: x[2])

    parent = [-1] * (N + 1)


    def find(x):
        if parent[x] < 0:
            return x
        else:
            y = find(parent[x])
            parent[x] = y
            return y


    def union(x, y):
        x = find(x)
        y = find(y)
        if x != y:
            parent[min(x, y)] += parent[max(x, y)]
            parent[max(x, y)] = min(x, y)
            return True
        else:
            return False


    ans = 0
    for u, v, d in lines:
        if gender[u - 1] == gender[v - 1]:
            continue
        if union(u, v):
            ans += d

    if -parent[1] == N:
        return ans
    else:
        return -1


if __name__ == "__main__": 
    print(solution())