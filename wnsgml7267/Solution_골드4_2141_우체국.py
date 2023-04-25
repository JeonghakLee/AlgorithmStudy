import sys, math
input = sys.stdin.readline
n = int(input())
X = []
total_person = 0 # 전체 학생 수
for i in range(n):
    idx, person_cnt = map(int,input().split()) # 위치, 사람 수
    total_person += person_cnt
    X.append((idx, person_cnt))
total_person = math.ceil(total_person / 2)
X.sort()
for town in X:
    total_person -= town[1]
    if total_person <= 0:
        print(town[0])
        break