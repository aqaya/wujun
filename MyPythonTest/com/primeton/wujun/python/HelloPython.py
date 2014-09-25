#coding=utf-8
'''
Created on  
'''
import os
print "Hello python我!"
print os.getcwd()
print os.access("d:/web.xml", os.W_OK)

class Animal():
    a = 1
    def sayHello(self):
        print "我今年"+str(self.a)+"岁了！"

animal = Animal()
animal.a = 12
animal.sayHello()