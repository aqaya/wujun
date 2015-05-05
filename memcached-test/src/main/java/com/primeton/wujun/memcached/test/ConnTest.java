package com.primeton.wujun.memcached.test;

import java.util.Date;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class ConnTest {
	public static void main(String[] args) throws InterruptedException {
		MemCachedClient client = new MemCachedClient();
		String[] addr = { "192.168.6.82:11211" };
		Integer[] weights = { 3 };
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(addr);
		pool.setWeights(weights);
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(200);
		pool.setMaxIdle(1000 * 30 * 30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(30);
		pool.setSocketConnectTO(0);
		pool.initialize();
		MyBean mb = new MyBean("wujun", 28);
		client.set("user", mb);
		MyBean mb2 = (MyBean) client.get("user");
		System.out.println(mb2.toString());
		// 将数据放入缓存
		client.set("test2", "test2");
		
		// 将数据放入缓存,并设置失效时间
		Date date = new Date(2000000);
		client.set("test1", "test1", date);
		client.addOrIncr("key3", 5);
		Thread.sleep(1000);
		System.out.println(client.get("key3"));
		String str = (String) client.get("test1");
		System.out.println(str);
	}

}
