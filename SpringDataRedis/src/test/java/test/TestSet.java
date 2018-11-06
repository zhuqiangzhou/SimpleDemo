package test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestSet {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 存值
	 */
	@Test
	public void testSet() {
		redisTemplate.boundSetOps("name").add("曹操");
		redisTemplate.boundSetOps("name").add("刘备");
		redisTemplate.boundSetOps("name").add("孙权");
	}
	
	
	/**
	 * 取值
	 */
	@Test
	public void getValue() {
		Set members = redisTemplate.boundSetOps("name").members();
		System.out.println(members);
	}
	
	
	/**
	 * 删除集合中的某个值
	 */
	@Test
	public void deleteValue() {
		redisTemplate.boundSetOps("name").remove("曹操");
	}
	
	
	/**
	 * 删除整个集合
	 */
	@Test
	public void deleteAllValue(){
		redisTemplate.delete("name");
	}

}
