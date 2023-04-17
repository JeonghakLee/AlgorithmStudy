n = int(input())
arr = list(map(int,input().split()))
answer = [-1 for _ in range(n)]
stack = []
for i in range(n-2, -1, -1):
    if arr[i] < arr[i+1] and arr[i] < answer[i+1]: # 둘 다 클 때
      answer[i] = arr[i+1]
      stack.append(answer[i+1]) # 이 전에 있던 큰 수는 스택에 담아둠
    elif arr[i] < arr[i+1]: # 바로 뒤에 있는 값이 크면
       answer[i] = arr[i+1]
    elif arr[i] < answer[i+1]: # 이전에 있던 값중 큰 수
      answer[i] = answer[i+1]
    else: # 둘 다 작을 때
      while(stack): # 스택에서 더 큰 수가 있는지 찾기
         p = stack.pop()
         if arr[i] < p:
            answer[i] = p
            break
       
print(*answer)