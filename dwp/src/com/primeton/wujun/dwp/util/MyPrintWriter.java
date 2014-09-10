package com.primeton.wujun.dwp.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

class MyPrintWriter extends PrintWriter {    
    ByteArrayOutputStream myOutput;   //此即为存放response输入流的对象    
 
    public MyPrintWriter(ByteArrayOutputStream output) {    
       super(output);    
       myOutput = output;    
    }    
    public ByteArrayOutputStream getByteArrayOutputStream() {    
       return myOutput;    
    }    
 }    
