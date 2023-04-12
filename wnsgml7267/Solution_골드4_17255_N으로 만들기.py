def dfs(string):
    global answer
    L = set(list(string))
    if len(L) == 1:
        answer+=1
        return
    else:
        dfs(string[1:])
        dfs(string[:-1])

n = input()
answer = 0
dfs(n)
print(answer)