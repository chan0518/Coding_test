li = []
for _ in range(10):
    a = int(input())
    li.append(a%42)
li = set(li)
print(len(li))