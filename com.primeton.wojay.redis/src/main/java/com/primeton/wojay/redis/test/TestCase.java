package com.primeton.wojay.redis.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

class TestCase{
	public static void main(String[] args) {
		JedisPool jp = new JedisPool("192.168.1.104");
		
		Jedis jedis = jp.getResource();//new Jedis("192.168.6.196",6379);
		jedis.set("a", "1");
		jedis.set("b", "2");
		System.out.println(jedis.get("time"));
		System.out.println(jedis.get("time"));
		Map<String,String> hm = new HashMap<String, String>();
		hm.put("a", "2");
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