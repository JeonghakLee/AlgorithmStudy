# 3967 매직스타 G5

nums = []
visit = 1
use = 0
loc = []
sums = [0] * 6
lines = [
    [0, 4],
    [1, 5],
    [0, 5],
    [4, 5],
    [3, 5],
    [0, 1],
    [3, 4],
    [0, 2],
    [1, 2],
    [2, 3],
    [2, 4],
    [1, 3],
]
visit = [0] * 13
for i in range(5):
    temp = input()
    for j in range(9):
        if temp[j] == ".":
            continue
        loc.append((i, j))
        if temp[j] == "x":
            nums.append(-1)
        else:
            nums.append(ord(temp[j]) - ord("A") + 1)
            visit[nums[-1]] = 1
            a, b = lines[len(nums) - 1]
            sums[a] += nums[-1]
            sums[b] += nums[-1]
#     1
#  2 3 4 5
#   6   7
#  8 9 10 11
#     12


def bt(n):
    if n == 12:
        for i in range(12):
            x, y = loc[i]
            magicstar[x][y] = chr(nums[i] + ord("A") - 1)
        for i in range(5):
            print("".join(magicstar[i]))
        exit()
    if nums[n] != -1:
        bt(n + 1)
        return
    a, b = lines[n]
    for i in range(1, 13):
        if visit[i]:
            continue
        if sums[a] + i <= 26 and sums[b] + i <= 26:
            sums[a] += i
            sums[b] += i
            nums[n] = i
            visit[i] = 1
            bt(n + 1)
            visit[i] = 0
            nums[n] = -1
            sums[a] -= i
            sums[b] -= i


magicstar = [["."] * 9 for _ in range(5)]


bt(0)