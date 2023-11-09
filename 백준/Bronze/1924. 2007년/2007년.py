x, y = list(map(int, input().split()))
weekday = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
num_week = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
a = [1, 3, 5, 7, 8, 10, 12]#31일
b = [4, 6, 9, 11]#30일
#2월 28일
s = 7#1월기준 나머지가 1이면 월요일

#1월 1일은 월요일
for i in range(1,x+1):#1월이면 y%7    2월이면 1월이 31일이니까 31+ y해서 %7해야하고 3월이면 1월+2월 + y 해야함
    y += num_week[i-1]
    y %= 7
print(weekday[y])