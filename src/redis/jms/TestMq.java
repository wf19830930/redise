package redis.jms;

import redis.clients.jedis.Jedis;

public class TestMq {
	public static byte[] redisKey = "key".getBytes();  
      
	public static void main(String[] args) throws Exception {
		 System.out.println("go!");  
		 
		        try { 
					init();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		     
	        pop();  
	}
	   
	    private static void pop() throws Exception {  
	        byte[] bytes1 = JedisUtil.rpop(redisKey);  
	        Message msg1 = (Message) ObjectUtil.bytesToObject(bytes1);  
	        if(msg1 != null){  
	            System.out.println(msg1.getId()+"   "+msg1.getContent());  
	        } 
	        byte[] bytes2 = JedisUtil.rpop(redisKey);  
	        Message msg2 = (Message) ObjectUtil.bytesToObject(bytes2);
	        if(msg2 != null){  
	            System.out.println(msg2.getId()+"   "+msg2.getContent());  
	        }
	        byte[] bytes3 = JedisUtil.rpop(redisKey);  
	        Message msg3 = (Message) ObjectUtil.bytesToObject(bytes3); 
	        
	         
	        if(msg3 != null){  
	            System.out.println(msg3.getId()+"   "+msg3.getContent());  
	        } 
	    }  
	   
	    private static void init() throws Exception {  
	    	
	    	
	        Message msg1 = new Message(1, "内容1");  
	        JedisUtil.lpush(redisKey, ObjectUtil.objectToBytes(msg1));  
	        Message msg2 = new Message(2, "内容2");  
	        JedisUtil.lpush(redisKey, ObjectUtil.objectToBytes(msg2));  
	        Message msg3 = new Message(3, "内容3");  
	        JedisUtil.lpush(redisKey, ObjectUtil.objectToBytes(msg3)); 
	        System.out.println(msg1.getContent());  
	        System.out.println(msg2.getContent());  
	        System.out.println(msg3.getContent());  
	    }  
		
	
}
