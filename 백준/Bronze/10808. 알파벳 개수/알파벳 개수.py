li_en = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
li = [0]*26
a = input()
for i in range(len(a)):
    w = li_en.index(a[i])
    li[w] += 1
for i in li:
    print(i, end=" ")
