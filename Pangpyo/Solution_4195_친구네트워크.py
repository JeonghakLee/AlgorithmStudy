import sys


input = sys.stdin.readline

def solution() :
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
            parent[min(x, y)] += parent[max(x, y)] # 부모인덱스는 음수를 가지며, 이 음수가 해당 집합에 포함된 원소 개수이다.
            parent[max(x, y)] = min(x, y)


    def check(n):
        if not n in dic: # 처음 나온 이름인 경우 parent 리스트를 하나 늘려준다.
            dic[n] = len(parent) # 해당 이름이 parent의 몇번째 인덱스인지 저장
            parent.append(-1)

    F = int(input())
    parent = []
    ans = []
    dic = {}
    for i in range(F):
        a, b = input().rsplit()
        check(a)
        check(b)
        union(dic[a], dic[b])
        ans.append(-parent[find(dic[a])]) # a와b는 한 집합이 되었으므로 해당 집합의 원소 개수를 출력한다.
    return ans

if __name__ == "__main__":
    for _ in range(int(input())):
        print(*solution(), sep="\n")