def solution():
    N = int(input())
    nums = set(map(int, input().split()))

    def bt(cnt, A):
        if cnt == N:
            print(*A)
            exit()
        if not A[-1] % 3 and A[-1] // 3 in nums:
            bt(cnt + 1, A + [A[-1] // 3])
        if A[-1] * 2 in nums:
            bt(cnt + 1, A + [A[-1] * 2])

    for n in nums:
        bt(1, [n])


if __name__ == "__main__":
    solution()