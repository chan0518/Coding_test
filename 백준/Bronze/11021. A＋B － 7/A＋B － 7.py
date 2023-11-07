n = int(input())

for i in range(n):
    a = input()
    b = list(map(int, a.split()))
    print(f'Case #{i+1}: {b[0] + b[1]}')