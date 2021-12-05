def findCommon(sequence):
    count1s = 0
    for bit in sequence:
        if bit == "1":
            count1s += 1
        if count1s > len(sequence) / 2:
            return "1"
    if count1s == len(sequence) / 2:
        return "-1"
    return "0"

# Part 1
data = open('data/day3.txt')
bits = []
for i in range(12):
    bits.append('')
for line in data:
    for i in range(len(line.strip())):
        bits[i] += line[i]

gamma = ""       
for sequence in bits:
    gamma += findCommon(sequence)
mask = 2**len(gamma) - 1
gamma_dec = int(gamma, 2)
epilson = ~gamma_dec & mask
print(gamma_dec*epilson)

# Part 2
from collections import Counter
data = open('data/day3.txt')
nums = []
for line in data:
    nums.append(line.strip())
nums2 = nums.copy()

theta = ''
epsilon = ''
# Oxygen generator rating
for i in range(len(nums[0])):
	common = Counter([x[i] for x in nums])
	if common['0'] > common['1']:
		nums = [x for x in nums if x[i] == '0']
	else:
		nums = [x for x in nums if x[i] == '1']
	theta = nums[0]
# CO2 rating
for i in range(len(nums2[0])):
	common = Counter([x[i] for x in nums2])

	if common['0'] > common['1']:
		nums2 = [x for x in nums2 if x[i] == '1']
	else:
		nums2 = [x for x in nums2 if x[i] == '0']
	if nums2:
		epsilon = nums2[0]
        
print(int(theta,2)*int(epsilon,2))
