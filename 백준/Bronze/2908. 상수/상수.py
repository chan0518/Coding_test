a, b = map(int, input().split())
aa = a//100 + a%100//10*10 + a%10*100
bb = b//100 + b%100//10*10 + b%10*100

print(aa if aa>bb else bb)