x= int(input())
cnt = 1
while True:
    x -= cnt
    cnt +=1
    if x <= 0:
        break

# std = abs(cnt)-1
if cnt % 2 == 0: # 짝수
    print(f'{cnt - (cnt + x - 1)}/{cnt + x - 1}')

else: # 홀수
    print(f'{cnt + x - 1}/{cnt - (cnt + x - 1)}')