#coding=utf-8
'''
Created on 2014年9月26日

@author: wjaxm_000
'''
import os

def anyTrue(predicate, sequence):
    return True in map(predicate, sequence)

def filterFiles(folder, exts):
    for fileName in os.listdir(folder):
        if os.path.isdir(folder + '/' + fileName):
            filterFiles(folder + '/' + fileName, exts)
        elif anyTrue(fileName.endswith, exts):
            print fileName