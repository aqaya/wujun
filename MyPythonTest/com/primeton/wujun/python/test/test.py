#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
'''


format = '5s 4x 3s'


import struct
print struct.unpack(format, 'Test astring')
print list(struct.unpack(format, 'Test astring'))
#('Test', 'ing')