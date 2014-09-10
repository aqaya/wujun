package com.primeton.wujun.dwp.util;

import java.io.ByteArrayOutputStream;    
import java.io.IOException;    
import java.io.PrintWriter;    
import java.io.UnsupportedEncodingException;    
import javax.servlet.http.HttpServletResponse;    
import javax.servlet.http.HttpServletResponseWrapper;    
public class WrapperResponse extends HttpServletResponseWrapper {    
   private MyPrintWriter tmpWriter;    
   private ByteArrayOutputStream output;    
   public WrapperResponse(HttpServletResponse httpServletResponse) {    
      super(httpServletResponse);    
      output = new ByteArrayOutputStream();    
      tmpWriter = new MyPrintWriter(output);    
   }    
   public void finalize() throws Throwable {    
      super.finalize();    
      output.close();    
      tmpWriter.close();    
   }    
   public String getContent() {    
      try {    
         tmpWriter.flush();   //刷新该流的缓冲，详看java.io.Writer.flush()    
         String s = tmpWriter.getByteArrayOutputStream().toString("UTF-8");    
         //此处可根据需要进行对输出流以及Writer的重置操作    
       //比如tmpWriter.getByteArrayOutputStream().reset()    
         return s;    
      } catch (UnsupportedEncodingException e) {    
         return "UnsupportedEncoding";    
      }    
   }    
   
   //覆盖getWriter()方法，使用我们自己定义的Writer    
   public PrintWriter getWriter() throws IOException {    
      return tmpWriter;    
   }    
   public void close() throws IOException {    
      tmpWriter.close();    
   }    
}
