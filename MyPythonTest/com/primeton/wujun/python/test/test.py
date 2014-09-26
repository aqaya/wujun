#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
'''
import httplib

conn=httplib.HTTPConnection("www.cnblogs.com")
conn.request("GET", "/coderzh/archive/2008/05/13/1194445.html")
r=conn.getresponse()
print r.read() 


import smtplib
smtpServer = 'smtp.primeton.com'
fromaddr = 'wujun@primeton.com'
toaddrs = 'wujun@primeton.com'
msg = 'Subject: Hello'
server = smtplib.SMTP()
server.connect(smtpServer)  
server.login("wujun@primeton.com","424424a")
server.sendmail(fromaddr, toaddrs, msg)
server.quit( )