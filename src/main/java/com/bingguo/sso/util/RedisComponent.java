package com.bingguo.sso.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
 
 
@Component
public class RedisComponent {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	public void set(String key, String value){
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		boolean bExistent = this.stringRedisTemplate.hasKey(key);
		if (bExistent) {
			System.out.println("this key is bExistent!");
		}else{
			ops.set(key, value);
		}
	}
	
	public String get(String key){
		return this.stringRedisTemplate.opsForValue().get(key);
	}
	
	public void del(String key){
		this.stringRedisTemplate.delete(key);
	}
}
