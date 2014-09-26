#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
'''
import socket
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

s.bind(("", 8081))

while True:
    # Receive up to 1,024 bytes in a datagram
    data, addr = s.recvfrom(1024)
    print "Received:", data, "from", addr