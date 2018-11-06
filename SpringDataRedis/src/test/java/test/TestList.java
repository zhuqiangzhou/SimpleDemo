package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class TestList {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 右压栈：后添加的元素排在后边
	 */
	@Test
	public void testValue1() {
		redisTemplate.boundListOps("name1").rightPush("刘备");
		redisTemplate.boundListOps("name1").rightPush("关羽");
		redisTemplate.boundListOps("name1").rightPush("曹操");
	}
	
	
	/**
	 * 显示右压栈的值
	 */
	@Test
	public void testGetValue1() {
		List list = redisTemplate.boundListOps("name1").range(0, 10);
		System.out.println(list);
	}
	
	/**
	 * 左压栈：先添加的排在后边
	 */
	@Test
	public void testValue2() {
		redisTemplate.boundListOps("name2").leftPush("刘备");
		redisTemplate.boundListOps("name2").leftPush("关羽");
		redisTemplate.boundListOps("name2").leftPush("曹操");
	}
	
	/**
	 * 显示左压栈的值
	 */
	@Test
	public void testGetValue2() {
		List list = redisTemplate.boundListOps("name2").range(0, 10);
		System.out.println(list);
	}
	
	
	/**
	 * 按照某个索引查询某个元素
	 */
	@Test
	public void testSearchByIndex() {
		String s = (String) redisTemplate.boundListOps("name1").index(1);
		System.out.println(s);

	}
	
	/**
	 * 移除某个元素
	 */
	@Test
	public void testRemoveByIndex(){
		redisTemplate.boundListOps("name1").remove(1, "关羽");
	}

}
