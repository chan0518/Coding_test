li_30 = []
for i in range(1,31):
    li_30.append(i)
li = []
for _ in range(28):
    a = int(input())
    if a in li_30:
        li_30.remove(a)
print(li_30[0])
print(li_30[1])
 
