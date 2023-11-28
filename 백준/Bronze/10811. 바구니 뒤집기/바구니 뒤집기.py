li = []
N, M = map(int, input().split())
for i in range(N+1):
    li.append(i)

for _ in range(M):
    i, j = map(int, input().split())
    idx = j
    for k in range(i,i+((j-i+1)//2)):
        tmp = li[k]
        li[k] = li[idx]
        li[idx] = tmp
        idx-=1

for i in range(1,N):
    print(li[i], end=' ')
print(li[N])