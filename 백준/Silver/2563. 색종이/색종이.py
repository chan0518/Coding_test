#import numpy as np

N = int(input())

# li = [[0]*100]*100
# for _ in range(100):
#     array.append([0]*100)
li = [[0] * 100 for _ in range(100)]    #[[0]*100]*100

for i in range(N):
    x, y = list(map(int, input().split()))
    for j in range(x,x+10):
        for k in range(y,y+10):
            li[j][k] = 1

count = 0
for j in range(100):
    for k in range(100):
        if li[j][k]==1:
            count += 1

print(count)

# print(li[10][8])

