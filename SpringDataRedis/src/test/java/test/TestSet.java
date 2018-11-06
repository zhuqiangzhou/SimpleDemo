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
	 * ��ֵ
	 */
	@Test
	public void testSet() {
		redisTemplate.boundSetOps("name").add("�ܲ�");
		redisTemplate.boundSetOps("name").add("����");
		redisTemplate.boundSetOps("name").add("��Ȩ");
	}
	
	
	/**
	 * ȡֵ
	 */
	@Test
	public void getValue() {
		Set members = redisTemplate.boundSetOps("name").members();
		System.out.println(members);
	}
	
	
	/**
	 * ɾ�������е�ĳ��ֵ
	 */
	@Test
	public void deleteValue() {
		redisTemplate.boundSetOps("name").remove("�ܲ�");
	}
	
	
	/**
	 * ɾ����������
	 */
	@Test
	public void deleteAllValue(){
		redisTemplate.delete("name");
	}

}
