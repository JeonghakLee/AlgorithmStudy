import sys
input = sys.stdin.readline
n, m = map(int,input().split()) # 입국 심사대 수, 친구 수
arr = []
result = 0
for i in range(n):
    arr.append(int(input()))
start = 0
end = min(arr) * m # arr의 최솟값 * m : 가장 많은 시간이 걸림
# end = 10**18 
while start <= end:
    mid = (start + end) // 2 # 시간의 최솟값

    friend_count = 0 # 친구 수
    for i in arr:
        friend_count += mid//i
        if m <= friend_count: # 더 많은 친구들이 입국할 수 있다면
            end = mid - 1 # 시간 줄이기
            result = mid
            break
    if m > friend_count:
        start = mid + 1

print(result)
