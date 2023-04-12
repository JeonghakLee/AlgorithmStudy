
def solution() :
    N = input()
    Nl = len(N)
    nums = set(list(N))
    N = int(N)
    ans = 0

    def dfs(n, cnt) :
        nonlocal ans
        if cnt == Nl :
            if int(n) == N :
                ans += 1
            return
        for num in nums :
            nnum = n + num
            numn = num + n
            dfs(nnum, cnt+1)
            if nnum != numn :
                dfs(numn, cnt+1)
    dfs("", 0)
    return ans


if __name__ == "__main__" :
    print(solution())