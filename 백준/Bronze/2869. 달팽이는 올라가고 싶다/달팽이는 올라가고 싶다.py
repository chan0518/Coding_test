a, b, v = map(int,input().split())
count = 1

c = a-b#낮밤
y = v-a

if v<=a:
    print(count)
else:
    if y/c > y//c:
        count += y//c + 1
    else:
        count += y//c
    print(count)