#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
ref:http://www.cnblogs.com/xiaowuyi/archive/2012/03/17/2404015.html
'''
def addlist(alist):
    for i in alist:
        yield i + 1

alist = [1, 2, 3, 4]
for x in addlist(alist):
    print x,
    
    
# def h():
#     print 'Wen Chuan'
#     yield 5
#     print 'Fighting!'


def h():
    print 'Wen Chuan',
    m = yield 5  # Fighting!
    print m
    d = yield 12
    print 'We are together!'
c = h()
c.next()
c.send('Fighting!') 
