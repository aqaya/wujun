package com.primeton.wujun.test.md5;

public class Main {    
    public static void main(String[] args) {    
         String pwd1="123";
         String pwd2="";
         
         CipherUtil cipher = new CipherUtil();    
         System.out.println("未加密的密码:"+pwd1);    
        //将123加密    
         pwd2 = cipher.generatePassword(pwd1);    
         System.out.println("加密后的密码:"+pwd2);    
         System.out.print("验证密码是否正确:");    
        if(cipher.validatePassword("202CB962AC59075B964B07152D234B70", pwd1)) {    
             System.out.println("正确");    
         }    
        else {    
             System.out.println("错误");    
         }    
     }    
 
}   

