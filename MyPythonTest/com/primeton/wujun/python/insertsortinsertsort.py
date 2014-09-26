#coding=utf-8
'''
Created on 2014年9月25日

@author: wjaxm_000
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