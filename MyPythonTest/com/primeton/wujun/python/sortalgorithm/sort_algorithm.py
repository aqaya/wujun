#coding=utf-8
'''
Created on Sep 25, 2014

@author: aqaya
'''

'''
冒泡排序
'''
def bubblesort(data):
    for i in range(len(data) - 1, 0, -1):
        for j in range(0, i):
            if data[j] > data[j + 1]:
                data[j], data[j + 1] = data[j + 1], data[j]



'''
对排序(调整堆)
'''
def heap_adjust(data, s, m):
    if 2 * s > m:
        return
    temp = s - 1
    if data[2*s - 1] > data[temp]:
        temp = 2 * s - 1
    if 2 * s <= m - 1 and data[2*s] > data[temp]:
        temp = 2 * s
    if temp <> s - 1:
        data[s - 1], data[temp] = data[temp], data[s - 1]
        heap_adjust(data, temp + 1, m)
        
'''
堆排序
'''
def heap_sort(data):
    m = len(data) / 2
    for i in range(m, 0, -1):
        heap_adjust(data, i, len(data))
    data[0], data[-1] = data[-1], data[0]
    for n in range(len(data) - 1, 1, -1):
        heap_adjust(data, 1, n)
        data[0], data[n - 1] = data[n - 1], data[0]
        
        
'''
插入排序
'''        
def insert_sort(data):
    for i in range(1,len(data)):
        tmp = data[i]
        j = i-1
        while j>=0 and tmp<data[j]:
            data[j+1]=data[j]
            j=j-1
        if j<>i-1:
            data[j+1] = tmp
            
'''
快速排序
'''            
def quicksort(data, low = 0, high = None):
    if high == None:
        high = len(data) - 1
    if low < high:
        s, i, j = data[low], low, high
        while i < j:
            while i < j and data[j] >= s:
                j = j - 1
            if i < j:
                data[i] = data[j]
                i = i + 1
            while i < j and data[i] <= s:
                i = i + 1
            if i < j:
                data[j] = data[i]
                j = j - 1
        data[i] = s
        quicksort(data, low, i - 1)
        quicksort(data, i + 1, high)
        
        
'''
选择排序
'''    
def selection_sort(data):
    for i in range(len(data) - 1):
        min = data[i]
        k = i
        for j in range(i, len(data)):
            if data[j] < min:
                min = data[j]
                k = j
        if i <> k:
            data[i], data[k] = data[k], data[i]




'''
希尔排序
'''          
def shell_sort(data, n = None):
    if n == None:
        n = len(data) / 2
        if n % 2 == 0:
            n = n + 1
    for i in range(0, n):
        newdata = data[i:len(data):n]
        insert_sort(newdata)
        data[i:len(data):n] = newdata
    if n <> 1:
        d = n / 2
        if d % 2 == 0:
            d = d + 1
        shell_sort(data, d)
