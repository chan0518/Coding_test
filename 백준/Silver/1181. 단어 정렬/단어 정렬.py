N = int(input())
li = []
for i in range(N):
    li.append(input())
li = list(set(li))#중복 제거
N = len(li)

li.sort()
li.sort(key = len)

for i in li:
    print(i)
