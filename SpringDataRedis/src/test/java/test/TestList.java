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
	 * ��ѹջ������ӵ�Ԫ�����ں��
	 */
	@Test
	public void testValue1() {
		redisTemplate.boundListOps("name1").rightPush("����");
		redisTemplate.boundListOps("name1").rightPush("����");
		redisTemplate.boundListOps("name1").rightPush("�ܲ�");
	}
	
	
	/**
	 * ��ʾ��ѹջ��ֵ
	 */
	@Test
	public void testGetValue1() {
		List list = redisTemplate.boundListOps("name1").range(0, 10);
		System.out.println(list);
	}
	
	/**
	 * ��ѹջ������ӵ����ں��
	 */
	@Test
	public void testValue2() {
		redisTemplate.boundListOps("name2").leftPush("����");
		redisTemplate.boundListOps("name2").leftPush("����");
		redisTemplate.boundListOps("name2").leftPush("�ܲ�");
	}
	
	/**
	 * ��ʾ��ѹջ��ֵ
	 */
	@Test
	public void testGetValue2() {
		List list = redisTemplate.boundListOps("name2").range(0, 10);
		System.out.println(list);
	}
	
	
	/**
	 * ����ĳ��������ѯĳ��Ԫ��
	 */
	@Test
	public void testSearchByIndex() {
		String s = (String) redisTemplate.boundListOps("name1").index(1);
		System.out.println(s);

	}
	
	/**
	 * �Ƴ�ĳ��Ԫ��
	 */
	@Test
	public void testRemoveByIndex(){
		redisTemplate.boundListOps("name1").remove(1, "����");
	}

}
