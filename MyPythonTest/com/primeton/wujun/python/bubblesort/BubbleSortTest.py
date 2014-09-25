#coding=utf-8
'''
Created on 2014年9月25日

@author: wjaxm_000
'''
import random
import datetime
import copy
from com.primeton.wujun.python.bubblesort.BubbleSort import bubblesort
sortfunc = bubblesort
data=[342,3434,234,34,54,6,2,76,87,90,3,5234,54,26,357]
def sort_perfmon(sortfunc, data):
    sort_data = copy.deepcopy(data)
    t1 = datetime.datetime.now()
    sortfunc(sort_data)
    print sort_data
    t2 = datetime.datetime.now()
    print sortfunc.__name__, t2 - t1
    
sort_perfmon(sortfunc,data) 
