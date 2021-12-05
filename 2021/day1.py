# Part 1
data = open('data/day1.txt')
prev = int(data.readline().strip())
inc = 0

next(data)
for line in data:
    curr = int(line.strip())
    if curr > prev:
        inc+=1
    prev = curr
print(inc)

# Part 2
data = open('data/day1.txt')
heights = []
for line in data:
    heights.append(int(line.strip()))
    
window = 3
inc = 0
for i in range(len(heights) - (window - 1)):
    if sum(heights[i:i+window]) < sum(heights[i+1:i+window+1]):
        inc += 1
print(inc)