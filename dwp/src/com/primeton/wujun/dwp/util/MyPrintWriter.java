package com.primeton.wujun.dwp.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

class MyPrintWriter extends PrintWriter {    
    ByteArrayOutputStream myOutput;   //�˼�Ϊ���response�������Ķ���    
 
    public MyPrintWriter(ByteArrayOutputStream output) {    
       super(output);    
       myOutput = output;    
    }    
    public ByteArrayOutputStream getByteArrayOutputStream() {    
       return myOutput;    
    }    
 }    
