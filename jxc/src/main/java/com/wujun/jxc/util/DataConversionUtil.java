package com.wujun.jxc.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class DataConversionUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List fromObjListToMapList(List all){
		List dataAll = new ArrayList();
		for(Iterator it=all.iterator();it.hasNext();){
			Map map = new LinkedHashMap();
			Object obj = it.next();
			Class c = obj.getClass();
			Field[] f=c.getDeclaredFields();
			int len = f.length;
			for(int i=0;i<len;i++){
				Field fd=f[i];
				if(Modifier.isStatic(fd.getModifiers()))
					continue;
				String param=f[i].getName();
				Method[] methods = obj.getClass().getMethods();
				for (int idx = 0; idx < methods.length; idx++) {
					 String mName = "get"+param.substring(0, 1).toUpperCase()+param.substring(1);
			            if (methods[idx].getName().equals(mName)) {
			            	try {
								Method method = c.getMethod(mName);
								map.put(param, method.invoke(obj, new Object[0]));
							} catch (Exception e) {
								e.printStackTrace();
							} 
			            }
			     }
				
			}
			dataAll.add(map);
		}
		return dataAll;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static Object mapToEntity(Class clazz, Map<String,Object> map) throws InstantiationException, IllegalAccessException{
		Object obj = clazz.newInstance();//新建一个用户对象将HashMap类型的用户信息放入到里面
		try {
			BeanUtils.populate(obj, map);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	} 
	
}
