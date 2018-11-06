package test;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestHash {
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 存值
	 */
	@Test
	public void testSetValue() {
		redisTemplate.boundHashOps("namehash").put("a", "唐僧");
		redisTemplate.boundHashOps("namehash").put("b", "悟空");
		redisTemplate.boundHashOps("namehash").put("c", "八戒");
		redisTemplate.boundHashOps("namehash").put("d", "沙僧");
	}
	
	/**
	 * 获取所有的key
	 */
	@Test
	public void testGetKeys() {
		Set keys = redisTemplate.boundHashOps("namehash").keys();
		System.out.println(keys);
	}
	
	/**
	 * 获取所有的value
	 */
	
	@Test
	public void testGetValue() {
		List list = redisTemplate.boundHashOps("namehash").values();
		System.out.println(list);
	}
	
	/**
	 * 根据key取值
	 */
	@Test
	public void searchValueByKey() {
		String str = (String)redisTemplate.boundHashOps("namehash").get("b");
		System.out.println(str);
	}
	
	@Test
	public void testRemoveValueByKey(){
		redisTemplate.boundHashOps("namehash").delete("c");
	}

}

