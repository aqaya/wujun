'''
Created on Sep 25, 2014

@author: aqaya

'''
import random
import sort_algorithm
a=[]
for i in range(0,11):
    a.insert(len(a),random.randint(0,35565))

print a
sort_algorithm.quicksort(a)
print a