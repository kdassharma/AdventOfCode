# Part 1
data = open('data/day2.txt')
x = 0
y = 0
for line in data:
    curr = line.strip().split() 
    if curr[0] == "forward":
        x += int(curr[1])
    elif curr[0] == "up":
        y -= int(curr[1])
    else:
        y += int(curr[1])
print(x*y)

# Part 2
data = open('data/day2.txt')
x = 0
y = 0
aim = 0
for line in data:
    curr = line.strip().split() 
    if curr[0] == "forward":
        x += int(curr[1])
        y += aim * int(curr[1])
    elif curr[0] == "up":
        aim -= int(curr[1])
    else:
        aim += int(curr[1])
print(x*y)