#coding=utf-8
'''
Created on 2014年9月25日

@author: wjaxm_000
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
def heap_sort(data):
    m = len(data) / 2
    for i in range(m, 0, -1):
        heap_adjust(data, i, len(data))
    data[0], data[-1] = data[-1], data[0]
    for n in range(len(data) - 1, 1, -1):
        heap_adjust(data, 1, n)
        data[0], data[n - 1] = data[n - 1], data[0]