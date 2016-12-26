package redis.jms;

import java.util.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Main {

	static Map<String, JedisPool> map = new HashMap();
	public  JedisPool jedisPool=null;
	public String redisIp  ;
	public int reidsPort  ;
	public  Main(String redisIp,int reidsPort) {
		this.redisIp=redisIp;
		this.reidsPort=reidsPort;
		 
		init();
	}
	
	public void init( ){
		 
		//jedis对象key
		String  jediskey=redisIp+reidsPort;
		//判断是否已经存在jedis队像
		if(map.containsKey(jediskey)){
			this.jedisPool=(JedisPool)map.get(jediskey);
		}
		else{
			this.jedisPool = new JedisPool(new JedisPoolConfig(), this.redisIp,this.reidsPort);
			 
			map.put(jediskey,jedisPool);
			 
		}
	}
	public JedisPool GetJedisPoolbyMain(){
		
		
		return this.jedisPool;
	}
}