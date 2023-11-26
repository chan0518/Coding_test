N, M = map(int, input().split())
li = [0]
for i in range(1,N+1):
    li.append(i)

for k in range(M):
    i, j = map(int, input().split())
    temp = li[i]
    li[i] = li[j]
    li[j] = temp
for i in range(1,N):
    print(li[i], end=' ')
print(li[N])