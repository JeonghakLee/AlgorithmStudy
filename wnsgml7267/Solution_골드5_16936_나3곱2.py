n = int(input())
B = set(map(int,input().split()))

def dfs(x):
    if x % 3 == 0:
        if x // 3 in B and x // 3 not in A:
            A.append(x // 3)
            dfs(x // 3)
        if x * 2 in B and x * 2 not in A:
            A.append(x * 2)
            dfs(x * 2)
    else:
        if x * 2 in B and x * 2 not in A:
            A.append(x * 2)
            dfs(x * 2)
    return
for i in B:
    A = [i]
    dfs(i)
    if len(A) == n:
        print(*A)
        break