n = int(input())

def plus_cycle(n,count,f):  #26
    a = n // 10
    b = n % 10
    c = a + b
    if c >= 10:
        c %= 10
    count += 1
    # if count == 1:
    #     return print(a,b,c,b*10+c)
    if (b*10+c)==f:
        return print(count)
    return plus_cycle((b*10)+c, count,f)

plus_cycle(n,0,n)
