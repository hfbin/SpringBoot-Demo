package cn.hfbin.cache;

import cn.hfbin.cache.bean.Employee;
import cn.hfbin.cache.mapper.EmployeeMapper;
import cn.hfbin.cache.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	//@Autowired
	//RedisTemplate<Object, Employee> employeeRedisTemplate;

	@Test
	public void contextLoads() {
		log.info(employeeMapper.getEmployeeById(1)+"");
		System.out.println();
	}

	@Test
	public  void redisTest(){

		stringRedisTemplate.opsForValue().append("key1" , "values1");

		log.info(stringRedisTemplate.opsForValue().get("key1"));

	}
	@Test
	public  void redisSaveEmpl(){

		Employee employeeById = employeeMapper.getEmployeeById(1);


		stringRedisTemplate.opsForValue().append(employeeById.getId()+"", JsonUtil.obj2String(employeeById));
		log.info("测试"+JsonUtil.string2Obj(stringRedisTemplate.opsForValue().get("1"),Employee.class));

	}


}
