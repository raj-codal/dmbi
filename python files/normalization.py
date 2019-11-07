#     float minMax(int v, int newMin, int newMax) {
#         return (((float) (v - min) * (newMax - newMin) / (max - min)) + newMin);
#     }

def minmax(oldvalue,oldmin,oldmax,newmin,newmax):
    return ((oldvalue-oldmin)*(newmax-newmin)/(oldmax-oldmin))+newmin
