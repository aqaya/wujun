#coding=utf-8
'''
Created on 2014年9月25日

@author: wjaxm_000
'''
import com.primeton.wujun.python.insertsort.InsertSort
from com.primeton.wujun.python.insertsort import InsertSort
def shell_sort(data, n = None):
    if n == None:
        n = len(data) / 2
        if n % 2 == 0:
            n = n + 1
    for i in range(0, n):
        newdata = data[i:len(data):n]
        InsertSort.insert_sort(newdata)
        data[i:len(data):n] = newdata
    if n <> 1:
        d = n / 2
        if d % 2 == 0:
            d = d + 1
        shell_sort(data, d)
