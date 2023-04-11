def solution() :
    N = int(input())

    nums = list(map(int, input().split()))

    answer = [-1] * N

    stack = []

    stack.append(0)
    for i in range(1, N):
        while stack and nums[stack[-1]] < nums[i]:
            answer[stack.pop()] = nums[i]
        stack.append(i)

    return answer


if __name__ == "__main__": 
    print(*solution())