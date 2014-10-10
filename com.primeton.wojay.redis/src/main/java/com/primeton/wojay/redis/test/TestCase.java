package com.primeton.wojay.redis.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

class TestCase{
	public static void main(String[] args) {
		JedisPool jp = new JedisPool("192.168.6.196");
		Jedis jedis = jp.getResource();//new Jedis("192.168.6.196",6379);
		jedis.set("foo", "bar");
		jedis.setex("time", 1, "1s");
		System.out.println(jedis.get("time"));
		try {
			Thread.sleep(998);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(jedis.get("time"));
		jedis.append("foo", "fuck");
		Map<String,String> hm = new HashMap<String, String>();
		hm.put("a", "1");
		hm.put("b", "2");
		jedis.hmset("hm", hm);
		String value = jedis.get("foo");
		Map<String, String> hasMap = jedis.hgetAll("hm");
		Set<Entry<String, String>> set = hasMap.entrySet();
		for(Entry<String, String> str : set){
			System.out.println(str.getKey()+":"+str.getValue());
		}
		System.out.println(value);
	}
}