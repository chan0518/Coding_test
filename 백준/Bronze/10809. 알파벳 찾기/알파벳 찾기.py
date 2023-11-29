li_az = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
li = [-1]*26
n = list(input())             
for i in range(len(n)-1,-1,-1):#역순
    a = li_az.index(n[i])
    li[a] = i
for i in range(len(li)-1):
    print(li[i], end=' ')
print(li[-1])