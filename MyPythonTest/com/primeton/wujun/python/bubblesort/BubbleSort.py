#coding=utf-8
'''
Created on 2014年9月25日

@author: wjaxm_000
'''
def bubblesort(data):
    for i in range(len(data) - 1, 0, -1):
        for j in range(0, i):
            if data[j] > data[j + 1]:
                data[j], data[j + 1] = data[j + 1], data[j]