package redis.jms;

import redis.clients.jedis.*;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		String redisIp = "127.0.0.1";
		int reidsPort = 6378;

		JedisMain m = new JedisMain(redisIp, reidsPort);
		final Jedis jedis = m.GetJedisPoolbyMain().getResource();

		final Subscriber subscriber = new Subscriber();
		final String channel = "mychannel";
		
	}
}
