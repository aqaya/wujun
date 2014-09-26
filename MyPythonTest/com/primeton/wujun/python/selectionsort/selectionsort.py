#coding=utf-8
'''
Created on 2014年9月25日

@author: wjaxm_000
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