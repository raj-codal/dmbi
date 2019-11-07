import normalization as n

datastring = '10 12 3 6 5 25 17 100 1000 98 11 27 78 33 9 18 23 44 690 200'
datastringarray = datastring.split(' ')
data = []
normalizeddata= []

for i in datastringarray:
    data.append(float(i))

oldmin = min(data)
oldmax = max(data)

for i in data:
    normalizeddata.append(n.minmax(i,oldmin,oldmax,0,1))

print(normalizeddata)