package com.primeton.wujun.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicProxyJDKTest {
	public static void main(String[] args) {
		class CountProxy implements InvocationHandler {

			private Object target;  
			    /** 
			     * 绑定委托对象并返回一个代理类 
			     * @param target 
			     * @return 
			     */  
			    public Object bind(Object target) {  
			        this.target = target;  
			        //取得代理对象  
			        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
			                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
			    }  
			  
			    /** 
			     * 调用方法 
			     */  
			    public Object invoke(Object proxy, Method method, Object[] args)  
			            throws Throwable {  
			        Object result=null;  
			        System.out.println("事务开始");  
			        //执行方法  
			        result=method.invoke(target, args);  
			        System.out.println("事务结束");  
			        return result;  
			    }  
		}
		
		
		class CountCglib implements MethodInterceptor {  
			    private Object target;  
			  
			    /** 
			     * 创建代理对象 
			     *  
			     * @param target 
			     * @return 
			     */  
			    public Object getInstance(Object target) {  
			        this.target = target;  
			        Enhancer enhancer = new Enhancer();  
			        enhancer.setSuperclass(this.target.getClass());  
			        // 回调方法  
			        enhancer.setCallback(this);  
			        // 创建代理对象  
			        return enhancer.create();  
			   }  
			 
			      
			    // 回调方法  
			    public Object intercept(Object obj, Method method, Object[] args,  
			            MethodProxy proxy) throws Throwable {  
			        System.out.println("事物开始");  
			        proxy.invokeSuper(obj, args);  
			        System.out.println("事物结束");  
			        return null;  
			  
			  
			    }  
			  
			}  

		 CountProxy proxy = new CountProxy();  
         ICount count = (ICount) proxy.bind(new CountImpl());  
         count.queryCount();
         
         CountCglib cglib = new CountCglib();  
         CountImpl countCglib=(CountImpl)cglib.getInstance(new CountImpl());  
         countCglib.queryCount(); 

	}
	

}
