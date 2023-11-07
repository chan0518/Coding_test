n = int(input())
a = list(map(int, input().split()))
v = int(input())

if v in a:
    print(a.count(v))
else:
    print(0)