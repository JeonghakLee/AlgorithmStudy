'''
이분 탐색
'''

N, M, L = map(int, input().split())
# 오름차순 정렬 : 휴게소 사이의 거리 중 최대 거리를 찾아야 하므로 + 이분탐색 해야해서
arr = sorted([0] + list(map(int,input().split())) + [L]) 

# 휴게소의 최소, 최대 거리
start = 1
end = L-1
answer = 0
# 이분탐색
while start <= end:
    # 휴게소 없는 구간 값 저장
    mid = (start + end) // 2 

    # 휴게소 설치 수
    shelter_cnt = 0 
    for i in range(1, len(arr)):
        # 해당 휴게소 사이 거리가 mid보다 클 경우 나눈 몫 만큼 휴게소 설치
        if mid < arr[i] - arr[i-1]:
            shelter_cnt += (arr[i] - arr[i-1] - 1) // mid
    
    # 설치할 수 있는 휴게소 개수를 넘은 경우 mid 증가
    if shelter_cnt > M: 
        start = mid + 1
    else:
        end = mid - 1
        answer = mid  # 현재까지의 최솟값 저장
        
print(answer)
