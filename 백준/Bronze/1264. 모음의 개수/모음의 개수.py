while True:
    n = input()
    n = n.lower()
    n = list(n)
    if '#' in n:
        break
    count = 0
    for i in n:
        if 'a' in i:
            count += 1
        if 'e' in i:
            count += 1
        if 'i' in i:
            count += 1
        if 'o' in i:
            count += 1
        if 'u' in i:
            count += 1
    print(count)