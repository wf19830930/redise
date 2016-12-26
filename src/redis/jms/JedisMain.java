package redis.jms;

import java.util.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisMain {

	static Map<String, JedisPool> map = new HashMap();
	 
	public  JedisPool jedisPool=null;
	public String redisIp  ;
	public int reidsPort  ;
	public  JedisMain(String redisIp,int reidsPort) {
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
			Run(this.jedisPool);
			map.put(jediskey,jedisPool);
			
			
			
			 
		}
		
	}
	public JedisPool GetJedisPoolbyMain(){
		
		
		return this.jedisPool;
	}
	
	public void Run(JedisPool jedisPool){
			final Jedis   jedis=jedisPool.getResource();
		System.out.println(String.format(
		"redis pool is starting, redis ip %s, redis port %d",
		redisIp, reidsPort));
		
		final Subscriber subscriber = new Subscriber();
		final String channel = "mychannel";
		new Thread(new Runnable() {

			public void run() {
		try {

			jedis.subscribe(subscriber, channel );
		} catch (Exception e) {
			System.out.println(String.format(
					"subsrcibe channel error, %s", e));
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		System.out.println(Thread.currentThread().getName());
			}
		}).start();
	}
}
