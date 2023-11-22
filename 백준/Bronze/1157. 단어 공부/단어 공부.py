a = input().lower()
list_a = list(a)
li_set = list(set(a))
cnt = []

for i in li_set:
    b = a.count(i)
    cnt.append(b)
# print(li_set)
# print(cnt)

if cnt.count(max(cnt)) >= 2:
    print('?')
else:
    idx = cnt.index(max(cnt))
    print(li_set[idx].upper())