for i in range(int(input())):
  n, m = map(int,input().split())
  books = []
  visited = [0] * (n+1)

  for i in range(m):
    books.append(list(map(int,input().split())))

  books.sort(reverse=True)

  for i in books:
      for j in range(i[1], i[0]-1, -1):
          if not visited[j]:
              visited[j] = 1
              break
          
  print(visited.count(1))