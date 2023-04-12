import sys
input = sys.stdin.readline
sl = 25 # 모든 경우의 수의 개수

nums = list(map(int, input().split()))
N = len(nums)-1

inf = sys.maxsize

D = [[inf]*(sl) for _ in range(N)] # 기본 값을 inf로 초기화

D[0][1|1<<nums[0]] = 2 # 첫번째 발을 옮기는 비용은 항상 2이다. (0에서 발을 한칸 옮기므로)

def score(a, b) : # 각 경우에서 발을 옮기는 비용
    if a == 0 :
        return 2
    if abs(a-b) == 2 :
        return 4
    if a == b :
        return 1
    return 3


for i in range(N-1) :
    b = nums[i+1] # 이번에 옮겨갈 발판의 번호
    for j in range(sl) :
        if D[i][j] < inf: # inf인 경우는 없는 경우이므로 inf보다 작은 경우만 본다
            for a in range(5) :
                if j & 1<<a : # j는 현재 발의 위치들을 비트로 표현한 수이다. 해당 위치에 발이 있을 경우
                    temp = (j & ~(1<<a)) | 1<<b # 다른 위치로 발을 옮긴다.
                    D[i+1][temp] = min(D[i+1][temp], D[i][j] + score(a, b)) # 해당 경우에 드는 비용 비교


ans = min(D[-1])

print(ans)