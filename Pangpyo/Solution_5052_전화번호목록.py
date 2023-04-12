import sys

def solution():
    input = sys.stdin.readline
    K = int(input())
    numbers = sorted([input().rstrip() for _ in range(K)])
    head = "*"
    for n in numbers:
        if head == n[0 : len(head)]:
            return "NO"
        else:
            head = n
    return "YES"


if __name__ == "__main__":
    for _ in range(int(input())):
        print(solution())