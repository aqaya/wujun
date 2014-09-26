#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
'''

from urllib import urlopen
doc = urlopen("http://www.baidu.com").read()
print doc
print "----------------------"



from urllib import urlopen
doc = urlopen("http://www.baidu.com")
print doc.info()
print doc.info().getheader('Content-Type')


import os
print "n".join(["%s=%s" % (k, v)  for k, v in os.environ.items()])
print os.getenv("http_proxy")

import   os 
os.putenv("http_proxy",   "http://proxyaddr:<port>")

# import urllib
# # Use http://www.someproxy.com:3128 for http proxying
# proxies = {'http': 'http://www.someproxy.com:3128'}
# filehandle = urllib.urlopen(some_url, proxies=proxies)
# # Don't use any proxies
# filehandle = urllib.urlopen(some_url, proxies={})
# # Use proxies from environment - both versions are equivalent
# filehandle = urllib.urlopen(some_url, proxies=None)
# filehandle = urllib.urlopen(some_url)