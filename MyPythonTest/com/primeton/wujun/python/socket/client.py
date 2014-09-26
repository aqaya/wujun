#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
'''
import socket
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

port = 8081
host = "localhost"
while True:
    msg = raw_input()
    s.sendto(msg, (host, port))