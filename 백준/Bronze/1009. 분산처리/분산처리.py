T = int(input())

for i in range(T):
    a, b = map(int, input().split())
    a %= 10
    if a==0: print(10)
    elif a==1: print(1)
    elif a==2:
        if b%4==1: print(2)
        elif b%4==2: print(4)
        elif b%4==3: print(8)
        else: print(6)
    elif a==3:
        if b%4==1: print(3)
        elif b%4==2: print(9)
        elif b%4==3: print(7)
        else: print(1)
    elif a==4:
        if b%2==1: print(4)
        else: print(6)
    elif a==5: print(5)
    elif a==6: print(6)
    elif a==7:
        if b%4==1: print(7)
        elif b%4==2: print(9)
        elif b%4==3: print(3)
        else: print(1)
    elif a==8:
        if b%4==1: print(8)
        elif b%4==2: print(4)
        elif b%4==3: print(2)
        else: print(6)
    elif a==9:
        if b%2==1: print(9)
        else: print(1)


'''
1:1 1       1/2 1                                                           주기가 1
2/1 2       2/2 4       2/3 8       2/4 6       2/5 2      2/6 4            주기가 4
3/1 3       3/2 9       3/3 7       3/4 1       3/5 3      3/6 9            주기가 4
4/1 4       4/2 6       4/3 4       4/4 6                                   주기가 2
5/1 5       5/2 5       5/3 5                                               주기가 1
6/1 6       6/2 6       6/3 6                                               주기가 1
7/1 7       7/2 9       7/3 3       7/4 1       7/5 7                       주기가 4
8/1 8       8/2 4       8/3 2       8/4 6       8/5 8                       주기가 4
9/1 9       9/2 1       9/3 9                                               주기가 2
'''