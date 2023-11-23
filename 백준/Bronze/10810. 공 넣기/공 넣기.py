# 5 4
# 1 2 3
# 3 4 4
# 1 4 1
# 2 2 2
N, M = map(int, input().split())
li = [0]*(N+1)
for q in range(M):
    i, j ,k = map(int, input().split())
    for w in range(i,j+1):
        li[w] = k
for i in range(1,N+1):
    print(f'{li[i]} ', end='')